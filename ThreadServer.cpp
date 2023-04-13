//��������ƣ�  ���߳� +�����̵�С��Ŀ +���� +�߳�ͬ��+����                         ////���߳�+socket��̵�һ������ʹ�ã��û���������߳�ͬ��  socket���   �ٽ���   ȫ�ֱ���

//1����ÿһ�����ߵĿͻ��ˣ�����˻���һ���̻߳�ά��
//2���յ�����Ϣת����ȫ���Ŀͻ���
//3 ��ĳ���ͻ��˶Ͽ������ߣ�����Ҫ����Ͽ������ӡ���ô�����أ�
#include<stdio.h>
#include<Windows.h>
#include < process.h >
#pragma comment(lib,"ws2_32.lib")
#define MAX_CLNT 256  //����һ������߳���
#define MAX_BUF_SIZE 1024
SOCKET clnSocks[MAX_CLNT];  //�������ӿͻ��˵�socket������
int  clntCnt = 0;           //���ӵĿͻ��˸���

HANDLE hMutex;            //����һ������������ÿ���̶߳��ã����Զ���ȫ��

//6���յ�����Ϣת����ȫ���Ŀͻ���   ���ܺ���
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
//5ʵ��HandleCln����
unsigned WINAPI HandleCln(void* arg)

{   //����  ������Ϣ���շ���Ϣ

    //��ʱ���ӵ�socket�ı�� hClntSock
	SOCKET hClntSock =*((SOCKET*)arg);
	int iLen = 0, i;
	char szMsg[MAX_BUF_SIZE] = { 0 };
	while (1)                          
	{
		iLen = recv(hClntSock, szMsg, sizeof(szMsg), 0);
		if (iLen != 1)
		{
			SendMsg(szMsg, iLen);   //   ����6  ���յ�����Ϣת����ȫ���Ŀͻ���  ����
		}
		else
		{
			break;
		}
	}  
	//break����whileѭ�� �������ߵĹ���
	printf("��ʱ���ӵ���ĿΪ��%��\n", clntCnt);
	WaitForSingleObject(hMutex, INFINITE);
	//7  �������ߵĹ���
	// ȷ������һ�����������ˣ� ͨ��������ѯ
	for (i = 0; i < clntCnt; i++)
	{
		if (hClntSock == clnSocks[i])
		{
			//�Ѿ��ҵ����ߵ����� ���Ƴ�
			while (i++ < clntCnt)
			{
				clnSocks[i] = clnSocks[i + 1];
			}  //�Ƴ����
			break;
		}
	}
	//�Ƴ�������-1
	clntCnt--;
	printf("�Ͽ���ʱ���Ӻ���ĿΪ��%��\n", clntCnt);
	ReleaseMutex(hMutex);
	closesocket(hClntSock);

	return 0;
}
int main() 
{
	printf("This is Sever\n");
	// 1�����׽��ֿ�   //���غͳ�ʼ����ֱ�ӿ���������ͨ�õ�
	WORD wVersionRequested;
	WSADATA wsaData;
	int err;
	HANDLE hThread;
	wVersionRequested = MAKEWORD(1, 1);
	//  1 ��ʼ���׽��ֿ�   //���غͳ�ʼ����ֱ�ӿ���������ͨ�õ�
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
	//2  ����һ���������һ������

	hMutex = CreateMutex(NULL, FALSE, NULL);
	//3�����������׽���   �̶���ֱ�ӳ�

	SOCKET sockSrv = socket(AF_INET, SOCK_STREAM, 0);

	SOCKADDR_IN addrSrv;
	addrSrv.sin_addr.S_un.S_addr = htonl(INADDR_ANY);
	addrSrv.sin_family = AF_INET;
	addrSrv.sin_port = htons(9190);

	// ���׽��ֵ�����IP��ַ���˿ں�9190   �̶���ֱ�ӳ�
	if (bind(sockSrv, (SOCKADDR*)&addrSrv, sizeof(SOCKADDR)) == SOCKET_ERROR)
	{
		printf("bind ERRORnum = %d\n", GetLastError());
		return -1;
	}

	// ��ʼ����    �̶���ֱ�ӳ�
	if (listen(sockSrv, 5) == SOCKET_ERROR)
	{
		printf("listen ERRORnum = %d\n", GetLastError());
		return -1;
	}
	printf("start listen\n");
	
	
	///////////////////////////////////����Ϊ��Ҫ����  
	//4
	
	SOCKADDR_IN addrCli;
	int len = sizeof(SOCKADDR_IN);
	while (1)  //�����һֱ����
	{
		//�������Կͻ��˵�����
		SOCKET sockConn = accept(sockSrv, (SOCKADDR*)&addrCli, &len);
		//ÿ��һ�����ӣ��ͻ���һ���߳�ȥά���������  begin
		//8 ���� & �ͷ���
		WaitForSingleObject(hMutex, INFINITE);
		clnSocks[clntCnt] = sockConn;
		clntCnt++;  //���ӵĿͻ��˸���  ,����clnSocks[clntCnt++] = sockConn;
		ReleaseMutex(hMutex);
		hThread =(HANDLE) _beginthreadex(NULL, 0, &HandleCln, (void*)&sockConn, 0, NULL);
		printf("Client IP =%s \n,Num =%d\n", inet_ntoa(addrCli.sin_addr),clntCnt );
	}
	closesocket(sockSrv);  //�ر��ܻ�
	WSACleanup();
	return 0;
}  