import java.util.*;
import java.lang.*;

class Student
{
    float marks;
	float avg;
	float total=2;
	int subjects=1;
	String name;
	String grade;
	String standard;
	Scanner sc= new Scanner(System.in);
	
	void displayStudentData(int n)
	{
	    grade(n);
	    put();
	}
	void sget()
	{
		System.out.println("Enter the name");
		name=sc.next();
		System.out.println("Enter the standard");
		standard=sc.next();
	}
		
	void avg(int n)
	{
		avg =marks/n;
	}
			
	void grade(int n)
	{
	    avg(n);
		System.out.println("the student grade is");
		if(avg>=80)
		{
				System.out.println("A");
		}
		else if(avg>=60 && avg<80)
		{
				System.out.println("B");
			
		}
		else if(avg>=40 && avg<60 )
		{
				System.out.println("C");
		}
		else
		{
				System.out.println("D");
		}
	}	
	void put()
	{
		System.out.println("Student name: "+name);
		System.out.println("Student Class: "+standard);
		System.out.println("Student marks: "+marks+" out of "+total);
		System.out.println("Student Grade: "+grade);
		System.out.println("Student Average: "+avg);	
		sc.nextLine();
	}
}
class Admin extends Question
{
    Scanner s=new Scanner(System.in);
    private String[] a_name={"ABC"};
    private String[] a_pass={"abc"};
    protected Boolean access_granted=false;
    
    Admin()
    {
        System.out.print("\nUsername: ");
        String tempname=s.next();
        System.out.print("\nPassword: ");
        String temppass=s.next();
        for(int i=0;i<a_name.length;i++)
        {
            if(tempname==a_name[i]&&temppass==a_pass[i])
                access_granted=true;
            else 
                System.out.println("Access Denied");
        }
    }
    void insert()
    {
        if(access_granted)
        {
            String temp;
            System.out.println("Enter Question: ");
            temp= s.next();
            ques.add(temp);
            System.out.println("Enter Options: ");
            temp= s.next();
            opt.add(temp);
            System.out.println("Enter Answers: ");
            temp= s.next();
            ans.add(temp);
        }
    }
    void delete()
    {
        if(access_granted)
        {
            for(int i=0;i<n;i++)
            {
                System.out.println(i+" "+ques.get(i));
            }
            System.out.println("Which question do u wish to Delete (Enter Number)? ");
            int q_no=s.nextInt();
            ques.remove(q_no);
            opt.remove(q_no);
            ans.remove(q_no);
        }
    }
    void edit(float total, int subjects)
    {
        System.out.println("Enter Total Marks: ");
        total=s.nextFloat();
        System.out.println("Enter Total Number of Subjects: ");
        subjects=s.nextInt();
    }
}

class Question
{
    int n;
	Scanner sca = new Scanner(System.in);
	Vector ques= new Vector(10,3);
	Vector opt= new Vector(10,3);
	Vector ans= new Vector(10,3);
    Question()
    {
        ques.add("Question 1");
    	opt.add("a) 1\nb) 2\nc) 3\nd) 4");
    	ans.add("a");
    	ques.add("Question 2");
    	opt.add("a) 1\nb) 2\nc) 3\nd) 4");
    	ans.add("b");
    }
    public void get(Student S)
    {
        n= ques.size();
        for(int i=0;i<n;i++)
        {
            System.out.println(ques.get(i));
            System.out.println(opt.get(i));
            System.out.print("\nAns. ");
            String uans=sca.next();
            String temp= ans.get(i).toString();
                if(uans.compareTo(temp)==0)
                {
                	S.marks++;
                }
                else
                {
                	S.marks--;
                }
        }
    }
    public int numberOfQues()
    {
        n= ques.size();
        return n;
    }
}
public class Main
{
    public static void main(String[] args)
	{ 
	    Scanner scan=new Scanner(System.in);
	    Student s= new Student();
	    int ch;
	    Boolean exit=true;
	    do
	    {
	        System.out.println("1. Student Login\n2. Admin Login\n3. Exit Program\nEnter Choice: ");
	        ch=scan.nextInt();
	        switch(ch)
	        {
	            case 1:
	                    Question q=new Question();
	                    s.sget();
	                    q.get(s);
	                    s.displayStudentData(q.numberOfQues());
	                    break;
	            case 2:
	                    int choice;
	                    Admin a= new Admin();
	                    do
	                    {
	                        System.out.println("1. Add a Question\n2. Delete a Question\n3. Edit a Question\n4.Exit Admin Page\n5. Exit Program\nEnter a choice");
	                        choice=scan.nextInt();
	                        switch(choice)
	                        {
	                            case 1:a.insert();
	                                    break;
	                            case 2:a.delete();
	                                    break;
	                            case 3:a.edit(s.total,s.subjects);
	                                    break;
	                            case 4:
	                                    break;
	                            case 5:
	                                    exit=false;
	                                    break;
	                        }
	                    }while(choice==4||choice==5);
	                    break;
	            case 3:
	                    exit=false;
	                    break;
	        }
	    }while(exit);
    }    
}
