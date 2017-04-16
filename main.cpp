#include <iostream>

using namespace std;

class Test
{
public:
	Test() {}
	~Test() {}

	int GetInt();
	float GetFloat();
	void SetInt(int intIn);
	void SetFloat(float fIn);
private:
	int m_Int;
	float m_Float;
};

int Test::GetInt()
{
	return m_Int;
}

float Test::GetFloat()
{
	return m_Float;
}

void Test::SetInt(int intIn)
{
	m_Int = intIn;
}

void Test::SetFloat(float fIn)
{
	m_Float = fIn;
}

int Deal(int k)
{
	return k;
}

int Deal(float k)
{
	return (int)k;
}

template <typename O, typename F>
int CalAndDeal(O* ins, F func) 
{
	return Deal((ins->*func)());
}

int main()
{
	cout << "begin---------------------" << endl;

	Test test;
	test.SetInt(9);
	test.SetFloat(8.8);

	cout << CalAndDeal(&test, &Test::GetInt) << endl;
	cout << CalAndDeal(&test, &Test::GetFloat) << endl;

	cout << "end======================" << endl;
	system("pause");
	return 0;
}