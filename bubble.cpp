#include<iostream>
using namespace std;
#include<string>
struct Hero {
	string name;
	int age;
	string gender;
};
void bubbling(Hero hero[], int len) {  //������һ���ṹ��,[]��Ҫ���˼ӣ������� bubbling���ö�Ӧ
	for (int i = 0; i < len - 1; i++)
	{

		for (int j = 0; j < len - 1 - i; j++)
		{
			if (hero[j].age > hero[j + 1].age)
			{
				struct Hero temp; //�������������ǽṹ��
				temp = hero[j];
				hero[j] = hero[j + 1];
				hero[j + 1] = temp;

			}
		}
	}
}
void printHero(struct Hero hero[], int len)
{
	for (int i = 0; i < len; i++) {
		cout << "������" << hero[i].name << "���䣺" << hero[i].age
			<< "�Ա�" << hero[i].gender << endl;
	}
}
int main() {
	struct Hero hero[5] = {
		{"����",18,"��"},
		{"����",22,"��"},
		{"�ŷ�",20,"��"},
		{"����",21,"��"},
		{"����",19,"Ů"},
	};    //����ģ�һ���ǵü� 
	int len = sizeof(hero) / sizeof(hero[0]);
	for (int i = 0; i < len; i++) {
		cout << "������" << hero[i].name << "���䣺" << hero[i].age
			<< "�Ա�" << hero[i].gender << endl;
	}
	bubbling(hero, len);
	printHero(hero, len);
	system("pause");
	return 0;
}