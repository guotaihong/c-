#include<iostream>
using namespace std;
struct student
{
 //姓名
	string sName;
	int score;
};
//老师的结构体定义
struct teacher
{ 
	//姓名
	string tName;
	//学生数组
	struct student sArray[5];
};
//给老师和学生赋值的函数
void allocateSpace(struct teacher tArray[],int len) 
{
	string nameSeed = "ABCDE";
	for (int i = 0; i < len; i++) {   //这里int 记得加，不然i没定义
		tArray[i].tName = "Teacher_";
		tArray[i].tName += nameSeed[i];
		for (int j = 0; j < 5; j++) {
			tArray[i].sArray[j].sName = "Student_";   //老师结构体里的student结构体 的名字属性
			tArray[i].sArray[j].sName += nameSeed[j];  //如果没有；说明没结束，下一行的tArray报错
			tArray[i].sArray[j].score = 60;
		}
	 
	}
}
void printInfo(struct teacher tArray[],int len) {
	for (int i = 0; i < len; i++) {
		cout << "老师姓名： " << tArray[i].tName << endl;   //后面<< endl表示换行
		for (int j = 0; j < len; j++) {
			cout << "学生姓名：" << tArray[i].sArray[j].sName<<endl;
		}
	}
}
int main() {
	//1、创建3名老师的数组
	struct teacher tArray[3];
	//2、通过函数给三名老师信息赋值，并给老师带的学会赋值
	int len = sizeof(tArray) / sizeof(tArray[0]);
	allocateSpace(tArray, len);

	//3打印所有老师及所带的学生信息
	printInfo(tArray, len);   //不能这样printInfo(tArray, int len); int（类型）要在方法里
}