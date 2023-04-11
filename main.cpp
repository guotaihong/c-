////目的 窗口编程
////1、掌握cpp面向对象思想 2、理解消息机制 3、多态性
//#include <windows.h>
//#include <stdio.h>
//LPCTSTR clsName = "My";
//LPCTSTR msgName = "欢迎学习";
//
//
//LRESULT CALLBACK MyWinProc(
//	HWND hwnd,        // handle to window
//	UINT uMsg,        // message identifier
//	WPARAM wParam,    // first message parameter word
//	LPARAM lParam    // second message parameter long
//);
//// a 设计一个窗口类 b 注册窗口类 c创建窗口 d显示以及更新窗口 e 消息循环
//
//int WINAPI WinMain(
//	HINSTANCE hInstance,
//	HINSTANCE hPrevInstance,
//	LPSTR lpCmdLine,
//	int nShowCmd
//)
//{
//	//a 设计一个窗口类
//
//	// 1 定义和配置窗口对象
//
//	 //UINT      style;
//	//WNDPROC   lpfnWndProc;
//	//int       cbClsExtra;
//	//int       cbWndExtra;
//	//HINSTANCE hInstance;
//	//HICON     hIcon;
//	//HCURSOR   hCursor;
//	//HBRUSH    hbrBackground;
//	//LPCWSTR   lpszMenuName;
//	//LPCWSTR   lpszClassName;
//	WNDCLASS wndcls;
//	wndcls.cbClsExtra = NULL;
//	wndcls.cbWndExtra = NULL;
//	wndcls.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
//	wndcls.hCursor = LoadCursor(NULL, IDC_ARROW);
//	wndcls.hIcon = LoadIcon(NULL, IDI_APPLICATION);
//	wndcls.hInstance = hInstance;
//	//定义交互响应
//	wndcls.lpfnWndProc = MyWinProc;//回调
//	//定义窗口代号
//	wndcls.lpszClassName = clsName;
//	wndcls.lpszMenuName = NULL;
//	wndcls.style = CS_HREDRAW | CS_VREDRAW;
//	//通过设置窗口类的CS_HREDRAW和CS_VREDRAW样式，可以让应用程序在窗口大小更改时重绘工作区的全部内容
//	// 
//	// b 注册窗口类
//	RegisterClass(&wndcls);
//
//	//c 创建窗口  
//	HWND hwnd;
//	hwnd = CreateWindow(clsName, msgName, WS_OVERLAPPEDWINDOW, CW_USEDEFAULT,
//		CW_USEDEFAULT, CW_USEDEFAULT, CW_USEDEFAULT, NULL, NULL, hInstance, NULL);
//
//	//d 显示和刷新窗口
//	ShowWindow(hwnd, SW_SHOWNORMAL);
//	UpdateWindow(hwnd);
//
//	//e 消息循环  GetMessage只有在接收到WM_QUIT才会返回0
//	//TranslateMessage 翻译消息 WM_KEYDOWN和WM_KEYUP 合并为WM_CAHR
//	MSG msg;
//	while (GetMessage(&msg, NULL, NULL, NULL))
//	{
//		TranslateMessage(&msg);
//		DispatchMessage(&msg);
//	}
//	return msg.wParam;
//
//}
//
//
//LRESULT CALLBACK MyWinProc(
//	HWND hwnd,        // handle to window   //hwnd 是窗口的句柄
//	UINT uMsg,        // message identifier   //uMsg 是消息代码; 例如，WM_SIZE消息指示窗口已调整大小
//	WPARAM wParam,    // first message parameter word     wParam 和 lParam 包含与消息相关的其他数据。确切的含义取决于消息代码。
//	LPARAM lParam    // second message parameter long
//)
//{
//	//uMsg 消息类型
//	int ret;
//	HDC hdc;
//	switch (uMsg)
//	{
//	case WM_CHAR:
//		char szChar[20];
//		sprintf_s(szChar, "您刚才按下了: %c", wParam);
//		MessageBox(hwnd, szChar, "char", NULL);
//		break;
//
//	case WM_LBUTTONDOWN:
//		MessageBox(hwnd, "检测鼠标左键按下", "msg", NULL);
//		break;
//
//	case WM_PAINT:
//		PAINTSTRUCT ps;
//		hdc = BeginPaint(hwnd, &ps);
//		TextOut(hdc, 0, 0, "www.baidu.com", strlen("www.baidu.com"));
//		EndPaint(hwnd, &ps);
//		MessageBox(hwnd, "重绘", "msg", NULL);
//		break;
//
//	case WM_CLOSE:
//		ret = MessageBox(hwnd, "是否真的结束？", "msg", MB_YESNO);
//		if (ret == IDYES)
//		{
//			DestroyWindow(hwnd);
//		}
//		break;
//
//	case WM_DESTROY:
//		PostQuitMessage(0);
//		break;
//
//	default:
//		return DefWindowProc(hwnd, uMsg, wParam, lParam); 
//	}
//	return 0;
//} 

  //dos  main
// 
//目的：窗口程序
//1 掌握C++ 面向对象思想 2 理解消息机制 3 多态性
#include <windows.h>
#include <stdio.h>
LPCTSTR clsName = "My";
LPCTSTR msgName = "欢迎学习";


LRESULT CALLBACK MyWinProc(
	HWND hwnd,        // handle to window
	UINT uMsg,        // message identifier
	WPARAM wParam,    // first message parameter word
	LPARAM lParam    // second message parameter long
);
// a 设计一个窗口类 b 注册窗口类 c创建窗口 d显示以及更新窗口 e 消息循环

int WINAPI WinMain(
	HINSTANCE hInstance,
	HINSTANCE hPrevInstance,
	LPSTR lpCmdLine,
	int nShowCmd
)
{
	//a 设计一个窗口类

	// 1 定义和配置窗口对象
	WNDCLASS wndcls;
	wndcls.cbClsExtra = NULL;
	wndcls.cbWndExtra = NULL;
	wndcls.hbrBackground = (HBRUSH)GetStockObject(WHITE_BRUSH);
	wndcls.hCursor = LoadCursor(NULL, IDC_ARROW);
	wndcls.hIcon = LoadIcon(NULL, IDI_APPLICATION);
	wndcls.hInstance = hInstance;
	//定义交互响应
	wndcls.lpfnWndProc = MyWinProc;//回调
	//定义窗口代号
	wndcls.lpszClassName = clsName;
	wndcls.lpszMenuName = NULL;
	wndcls.style = CS_HREDRAW | CS_VREDRAW;

	// b 注册窗口类
	RegisterClass(&wndcls);

	//c 创建窗口  
	HWND hwnd;
	hwnd = CreateWindow(clsName, msgName, WS_OVERLAPPEDWINDOW, CW_USEDEFAULT,
		CW_USEDEFAULT, CW_USEDEFAULT, CW_USEDEFAULT, NULL, NULL, hInstance, NULL);

	//d 显示和刷新窗口
	ShowWindow(hwnd, SW_SHOWNORMAL);
	UpdateWindow(hwnd);

	//e 消息循环  GetMessage只有在接收到WM_QUIT才会返回0
	//TranslateMessage 翻译消息 WM_KEYDOWN和WM_KEYUP 合并为WM_CAHR
	MSG msg;
	while (GetMessage(&msg, NULL, NULL, NULL))
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}
	return msg.wParam;

}


LRESULT CALLBACK MyWinProc(
	HWND hwnd,        // handle to window
	UINT uMsg,        // message identifier
	WPARAM wParam,    // first message parameter word
	LPARAM lParam    // second message parameter long
)
{
	//uMsg 消息类型
	int ret;
	HDC hdc;
	switch (uMsg)
	{
	case WM_CHAR:
		char szChar[20];
		sprintf_s(szChar, "您刚才按下了: %c", wParam);
		MessageBox(hwnd, szChar, "char", NULL);
		break;

	case WM_LBUTTONDOWN:
		MessageBox(hwnd, "检测鼠标左键按下", "msg", NULL);
		break;

	case WM_PAINT:
		PAINTSTRUCT ps;
		hdc = BeginPaint(hwnd, &ps);
		TextOut(hdc, 0, 0, "www.baidu.com", strlen("www.baidu.com"));
		EndPaint(hwnd, &ps);
		MessageBox(hwnd, "重绘", "msg", NULL);
		break;

	case WM_CLOSE:
		ret = MessageBox(hwnd, "是否真的结束？", "msg", MB_YESNO);
		if (ret == IDYES)
		{
			DestroyWindow(hwnd);
		}
		break;

	case WM_DESTROY:
		PostQuitMessage(0);
		break;

	default:
		return DefWindowProc(hwnd, uMsg, wParam, lParam);
	}
	return 0;
}
