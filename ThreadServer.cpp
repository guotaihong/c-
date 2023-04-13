//服务器设计：  多线程 +网络编程的小项目 +队列 +线程同步+数组                         ////多线程+socket编程的一个联合使用，用互斥体进行线程同步  socket编程   临界区   全局变量

//1对于每一个上线的客户端，服务端会起一个线程会维护
//2将收到的消息转发给全部的客户端
//3 当某个客户端断开（下线），需要处理断开的链接。怎么处理呢？
#include<stdio.h>
#include<Windows.h>
#include < process.h >
#pragma comment(lib,"ws2_32.lib")
#define MAX_CLNT 256  //定义一个最大线程数
#define MAX_BUF_SIZE 1024
SOCKET clnSocks[MAX_CLNT];  //所有连接客户端的socket的数组
int  clntCnt = 0;           //连接的客户端个数

HANDLE hMutex;            //定义一个互斥量，在每个线程都用，所以定义全局

//6将收到的消息转发给全部的客户端   功能函数
void SendMsg(char* szMsg, int iLen)
{
	int i = 0;
	WaitForSingleObject(hMutex, INFINITE);
	for(i=0;i<clntCnt; i++)
	{
		send(clnSocks[i], szMsg, iLen,0);
	}
	ReleaseMutex(hMutex);
}
//5实现HandleCln函数
unsigned WINAPI HandleCln(void* arg)

{   //工人  处理消息，收发消息

    //此时连接的socket的标记 hClntSock
	SOCKET hClntSock =*((SOCKET*)arg);
	int iLen = 0, i;
	char szMsg[MAX_BUF_SIZE] = { 0 };
	while (1)                          
	{
		iLen = recv(hClntSock, szMsg, sizeof(szMsg), 0);
		if (iLen != 1)
		{
			SendMsg(szMsg, iLen);   //   调用6  将收到的消息转发给全部的客户端  函数
		}
		else
		{
			break;
		}
	}  
	//break跳出while循环 处理下线的过程
	printf("此时连接的数目为：%的\n", clntCnt);
	WaitForSingleObject(hMutex, INFINITE);
	//7  处理下线的过程
	// 确定是哪一个连接下线了？ 通过遍历查询
	for (i = 0; i < clntCnt; i++)
	{
		if (hClntSock == clnSocks[i])
		{
			//已经找到下线的连接 ，移除
			while (i++ < clntCnt)
			{
				clnSocks[i] = clnSocks[i + 1];
			}  //移除完毕
			break;
		}
	}
	//移除后总数-1
	clntCnt--;
	printf("断开此时连接后，数目为：%的\n", clntCnt);
	ReleaseMutex(hMutex);
	closesocket(hClntSock);

	return 0;
}
int main() 
{
	printf("This is Sever\n");
	// 1加载套接字库   //加载和初始可以直接拷贝，都是通用的
	WORD wVersionRequested;
	WSADATA wsaData;
	int err;
	HANDLE hThread;
	wVersionRequested = MAKEWORD(1, 1);
	//  1 初始化套接字库   //加载和初始可以直接拷贝，都是通用的
	err = WSAStartup(wVersionRequested, &wsaData);
	if (err != 0)
	{
		return err;
	}
	if (LOBYTE(wsaData.wVersion) != 1 || HIBYTE(wsaData.wVersion) != 1)
	{
		WSACleanup();
		return -1;
	}  
	//2  创建一个互斥对象（一把锁）

	hMutex = CreateMutex(NULL, FALSE, NULL);
	//3创建服务器套接字   固定的直接抄

	SOCKET sockSrv = socket(AF_INET, SOCK_STREAM, 0);

	SOCKADDR_IN addrSrv;
	addrSrv.sin_addr.S_un.S_addr = htonl(INADDR_ANY);
	addrSrv.sin_family = AF_INET;
	addrSrv.sin_port = htons(9190);

	// 绑定套接字到本地IP地址，端口号9190   固定的直接抄
	if (bind(sockSrv, (SOCKADDR*)&addrSrv, sizeof(SOCKADDR)) == SOCKET_ERROR)
	{
		printf("bind ERRORnum = %d\n", GetLastError());
		return -1;
	}

	// 开始监听    固定的直接抄
	if (listen(sockSrv, 5) == SOCKET_ERROR)
	{
		printf("listen ERRORnum = %d\n", GetLastError());
		return -1;
	}
	printf("start listen\n");
	
	
	///////////////////////////////////以下为重要代码  
	//4
	
	SOCKADDR_IN addrCli;
	int len = sizeof(SOCKADDR_IN);
	while (1)  //服务端一直运行
	{
		//接受来自客户端的连接
		SOCKET sockConn = accept(sockSrv, (SOCKADDR*)&addrCli, &len);
		//每来一个链接，就会起一个线程去维护这个链接  begin
		//8 加锁 & 释放锁
		WaitForSingleObject(hMutex, INFINITE);
		clnSocks[clntCnt] = sockConn;
		clntCnt++;  //连接的客户端个数  ,或者clnSocks[clntCnt++] = sockConn;
		ReleaseMutex(hMutex);
		hThread =(HANDLE) _beginthreadex(NULL, 0, &HandleCln, (void*)&sockConn, 0, NULL);
		printf("Client IP =%s \n,Num =%d\n", inet_ntoa(addrCli.sin_addr),clntCnt );
	}
	closesocket(sockSrv);  //关闭总机
	WSACleanup();
	return 0;
}  