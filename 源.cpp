#include<iostream>
using namespace std;
struct student
{
 //����
	string sName;
	int score;
};
//��ʦ�Ľṹ�嶨��
struct teacher
{ 
	//����
	string tName;
	//ѧ������
	struct student sArray[5];
};
//����ʦ��ѧ����ֵ�ĺ���
void allocateSpace(struct teacher tArray[],int len) 
{
	string nameSeed = "ABCDE";
	for (int i = 0; i < len; i++) {   //����int �ǵüӣ���Ȼiû����
		tArray[i].tName = "Teacher_";
		tArray[i].tName += nameSeed[i];
		for (int j = 0; j < 5; j++) {
			tArray[i].sArray[j].sName = "Student_";   //��ʦ�ṹ�����student�ṹ�� ����������
			tArray[i].sArray[j].sName += nameSeed[j];  //���û�У�˵��û��������һ�е�tArray����
			tArray[i].sArray[j].score = 60;
		}
	 
	}
}
void printInfo(struct teacher tArray[],int len) {
	for (int i = 0; i < len; i++) {
		cout << "��ʦ������ " << tArray[i].tName << endl;   //����<< endl��ʾ����
		for (int j = 0; j < len; j++) {
			cout << "ѧ��������" << tArray[i].sArray[j].sName<<endl;
		}
	}
}
int main() {
	//1������3����ʦ������
	struct teacher tArray[3];
	//2��ͨ��������������ʦ��Ϣ��ֵ��������ʦ����ѧ�ḳֵ
	int len = sizeof(tArray) / sizeof(tArray[0]);
	allocateSpace(tArray, len);

	//3��ӡ������ʦ��������ѧ����Ϣ
	printInfo(tArray, len);   //��������printInfo(tArray, int len); int�����ͣ�Ҫ�ڷ�����
}