#include<iostream>
using namespace std;
#include<string>
struct Hero {
	string name;
	int age;
	string gender;
};
void bubbling(Hero hero[], int len) {  //传的是一个结构体,[]不要忘了加，跟下面 bubbling调用对应
	for (int i = 0; i < len - 1; i++)
	{

		for (int j = 0; j < len - 1 - i; j++)
		{
			if (hero[j].age > hero[j + 1].age)
			{
				struct Hero temp; //交换定义类型是结构体
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
		cout << "姓名：" << hero[i].name << "年龄：" << hero[i].age
			<< "性别：" << hero[i].gender << endl;
	}
}
int main() {
	struct Hero hero[5] = {
		{"刘备",18,"男"},
		{"关羽",22,"男"},
		{"张飞",20,"男"},
		{"赵云",21,"男"},
		{"貂蝉",19,"女"},
	};    //这里的；一定记得加 
	int len = sizeof(hero) / sizeof(hero[0]);
	for (int i = 0; i < len; i++) {
		cout << "姓名：" << hero[i].name << "年龄：" << hero[i].age
			<< "性别：" << hero[i].gender << endl;
	}
	bubbling(hero, len);
	printHero(hero, len);
	system("pause");
	return 0;
}