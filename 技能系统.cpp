#include<iostream>

struct Skill  //所有技能类型属性（11个）
{
	int Mpp;
	int Spp;
	int Act;
	int ActB;
	int CoolDown;
};

struct USkill //用户技能状态，有struct Skill
{
	Skill* skill{};
	int     lv;
	int    cooldown;
	bool    buse{};  //技能是否使用
};

struct Role  //角色
{
	int Hp;
	int MaxHp;
	int Mp;
	int MaxMp;
	int Sp;
	int MaxSp;
	int Act;
	USkill  skills[5];  //五个技能，在11个技能中调用
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

	Role* User = new Role    /////////////////////////->     下面有 (*User).Hp =User[0].Hp ,这里skill[0].Mpp又是一个指针 ，=skill->Mpp
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
	std::cout << "角色姓名：好英俊" << std::endl;
	std::cout << "生命：" << (*User).Hp << "/" << User[0].MaxHp << std::endl;   //(*User).Hp =User[0].Hp
	std::cout << "内力：" << User->Mp << "/" << User[0].MaxMp << std::endl;   //User->Mp =
	std::cout << "怒气：" << User[0].Sp << "/" << User[0].MaxSp << std::endl;
	std::cout << "基本攻击：" << User[0].Act << std::endl;
	for (auto a : User[0].skills)
	{
		if (a.buse)
			std::cout
			<< "消耗MP" << a.skill[0].Mpp       //这里skill[0].Mpp又是一个指针 ，=skill->Mpp
			<< "消耗Sp" << a.skill[0].Spp
			<< "附加攻击" << a.skill[0].Act
			<< "翻倍攻击" << a.skill[0].ActB
			<< "冷却" << a.skill[0].CoolDown
			<< "技能等级" << a.lv << std::endl;
	}

}