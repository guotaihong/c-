#include<string.h>
#include<stdio.h>
#include<windows.h>
int main()
{
	char arr1[] = "welcome to HIT!!!!!!";
	char arr2[] = "####################";
	int left = 0;
	int right = strlen(arr1) - 1;
	while (left <= right)
	{
		arr2[left] = arr1[left];
		arr2[right] = arr1[right];
		printf("%s\n", arr2);
		Sleep(1000); //Ë¯ÃßÒ»Ãë£¬ÑÓ³Ù´òÓ¡£¬sÒª´óÐ´
		left++;
		right--;
	}return 0;
}
