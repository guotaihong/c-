#include<iostream>

struct Skill  //���м����������ԣ�11����
{
	int Mpp;
	int Spp;
	int Act;
	int ActB;
	int CoolDown;
};

struct USkill //�û�����״̬����struct Skill
{
	Skill* skill{};
	int     lv;
	int    cooldown;
	bool    buse{};  //�����Ƿ�ʹ��
};

struct Role  //��ɫ
{
	int Hp;
	int MaxHp;
	int Mp;
	int MaxMp;
	int Sp;
	int MaxSp;
	int Act;
	USkill  skills[5];  //������ܣ���11�������е���
};
int main() {
	Skill  AllSkills[11]{
		{0,0,10,1,0},
		{10,0,50,1,1},
		{10,0,60,1,1},
		{30,0,0,2,3},
		{30,0,300,0,3},
		{50,0,0,5,4},
		{50,0,500,0,4},
		{100,0,0,10,6},
		{100,0,50,2,6},
		{0,100,500,5,0},
		{0,100,200,10,0}
	};

	Role* User = new Role    /////////////////////////->     ������ (*User).Hp =User[0].Hp ,����skill[0].Mpp����һ��ָ�� ��=skill->Mpp
	{
		1000,1000,1000,1000,0,100,100,
		{
			{&AllSkills[0],0,0,true},
			{&AllSkills[1],0,0,true},
			{&AllSkills[2],0,0,true},
			{&AllSkills[3],0,0,false},
			{&AllSkills[10],0,0,true}
		 }
	};
	std::cout << "��ɫ��������Ӣ��" << std::endl;
	std::cout << "������" << (*User).Hp << "/" << User[0].MaxHp << std::endl;   //(*User).Hp =User[0].Hp
	std::cout << "������" << User->Mp << "/" << User[0].MaxMp << std::endl;   //User->Mp =
	std::cout << "ŭ����" << User[0].Sp << "/" << User[0].MaxSp << std::endl;
	std::cout << "����������" << User[0].Act << std::endl;
	for (auto a : User[0].skills)
	{
		if (a.buse)
			std::cout
			<< "����MP" << a.skill[0].Mpp       //����skill[0].Mpp����һ��ָ�� ��=skill->Mpp
			<< "����Sp" << a.skill[0].Spp
			<< "���ӹ���" << a.skill[0].Act
			<< "��������" << a.skill[0].ActB
			<< "��ȴ" << a.skill[0].CoolDown
			<< "���ܵȼ�" << a.lv << std::endl;
	}

}