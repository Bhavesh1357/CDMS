import java.lang.*;
import java.util.*;
import java.io.*;

// Database table/ schema
// create table  student(RID int,Name varchar(255),Salary int);


class CDMS
{
	public static void main(String arg[])throws Exception
	{
		DBMS dobj = new DBMS();

		dobj.StartDBMS();
		
	}
}

class Student
{
	public int RID;
	public String Name;
	public int Salary;
	public int Age;
	public String Address;

	private static int Generator;

	static
	{
		Generator=0;
	}

	public Student(String str,int value,int age,String adr)
	{
		this.RID = ++Generator;
		this.Name = str;
		this.Salary = value;
		this.Age = age;
		this.Address = adr;
	}

	public void DisplayData()
	{
		System.out.println("ID\t"+"Name\t"+"Salary\t"+"Age\t"+"Address");
		System.out.println("-----------------$$-------------------------------");
		System.out.println(this.RID+"\t"+this.Name+"\t"+this.Salary+"\t"+this.Age+"\t"+this.Address);
        System.out.println("--------------------------------------------------");
	}

}

class DBMS
{
	 public LinkedList <Student> lobj;

	 public DBMS()
	 {
	 	lobj = new LinkedList<>();


	 } 
   
   // Insert into student Piyush 1000;
	// Select * from Student; 

	public void StartDBMS()
	{
		Scanner scanobj = new Scanner(System.in);

		System.out.println("Marvellous customised DBMS started succesfully.....");
		String Query = " ";
		System.out.println("Type  Help to Display all contents");

		while(true)
		{

			System.out.print("Marvellous DBMS console->");
			
			Query = scanobj.nextLine();


			String  tokens[] = Query.split(" ");
            int QuerySize = tokens.length;

            if(QuerySize==1)
            {
            	if("Help".equals(tokens[0]))
            	{
            		System.out.println("**************************************************************");
            		System.out.println("This application is used to demonstrates the customised DBMS");
            		System.out.println("Exit: Terminate DBMS");
            		System.out.println("Display all Data :select * from student");
            		System.out.println("Insert data: Insert into student Name Salary Age Address");
            		System.out.println("DisplaySpecific by RID:select * from student order by RID call");
            		System.out.println("DisplaySpecific by Name:select * from student order by name say");
            		System.out.println("DeleteSpecific by RID:Delete from student where RID call");
            		System.out.println("DeleteSpecific by name:Delete from student where name say");
            		System.out.println("Maximum salary:select max salary from student");
            		System.out.println("Minimum salary:select min salary from student");
            		System.out.println("Summation of Salary:select sum salary from student");
            		System.out.println("Average Salary:select avg salary from student");
            		System.out.println("Count No of Salary:select count salary from student");
                    System.out.println("Display by Address:select * from student where Address is");
                    System.out.println("Display by entered LIMIT:select * from student where LIMIT is"); 
                    System.out.println("Display by Age: select Name from student where age morethan is");
                    System.out.println("Display like: select name from student where name LIKE is");
                    System.out.println("**************************************************************");

            	}

            	else if("Exit".equals(tokens[0]))
            	{
            		System.out.println("Thank you for using Marvellous DBMS");
            		break;
            	}

            }

            else if(QuerySize==2)
            {

            }

            // select * from student;

            else if(QuerySize==4)
            {
            	if("select".equals(tokens[0]))
            	{
            		if("*".equals(tokens[1]))
            		{
            			DisplayAll();

            		}
            		
            	}
            }

            else if(QuerySize==5)
            {

            	 // select max salary from student;


            	if("max".equals(tokens[1]))
            	{
            		AggregateMax();
            	}

            	 // select min salary from student;


            	else if("min".equals(tokens[1]))
            	{
            		AggregateMin();
            	}

            	// select sum salary from student;

            	else if("sum".equals(tokens[1]))
            	{
            		AggregateSum();
            	}

            	// select avg salary from student;

            	else if("avg".equals(tokens[1]))
            	{
            		AverageSum();
            	}

            	// select count salary from student;

            	else if("count".equals(tokens[1]))
            	{
            		AggregateCount();
            	}
            }

           

           
            // Delete from student where RID call;
            // Delete from student where name say;

            else if(QuerySize==6)
            {
            	if("Delete".equals(tokens[0]))
            	{
            		if("call".equals(tokens[5]))
            		 {
            			DeleteSpecific(Integer.parseInt(tokens[4]));
            		 }

         		    if("say".equals(tokens[5]))
            		 {
            			DeleteSpecific(tokens[4]);
            		 }

            	}
            }

            else if(QuerySize==7)
            {
            	// Insert into student Piyush 1000 21 Pune;
            	if("Insert".equals(tokens[0]))
            	{
            		InsertData(tokens[3],Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]),tokens[6]);

            	}

            	// select * from student where Address is

            	else if("Address".equals(tokens[5]))
            	{
            		DisplayByAd(tokens[6]);

            	}

            	// select * from student where LIMIT is

            	else if("LIMIT".equals(tokens[5]))
            	{
            		DisplayByL(Integer.parseInt(tokens[6]));

            	}
            }



            // select * from student order by RID call;
            // select * from student order by name say;

            else if(QuerySize==8)
            {
            	if("select".equals(tokens[0]))
            	{
            		
            			if("call".equals(tokens[7]))
            		 {
            			DisplaySpecific(Integer.parseInt(tokens[6]));
            		 }

            		    else if("say".equals(tokens[7]))
            		 {
            			DisplaySpecific(tokens[6]);
            		 }
          
            	}

            	// select Name from student where age morethan is

            	else if("morethan".equals(tokens[6]))
            	{
            		DisplayMthn(Integer.parseInt(tokens[7]));
            	}

            	// select name from student where name LIKE is

            /*	else if("LIKE".equals(tokens[6]))
            	{
            		Displaylike(Integer.parseInt(tokens[7]));

            	}*/

            	
            }

		}
       

	}

	// insert into query

	public void InsertData(String str,int value,int age,String adr)
	{
		Student sobj = new Student(str,value,age,adr);

		lobj.add(sobj);

	}

	public void DisplayAll()
	{
		for(Student sref:lobj)
		{
			sref.DisplayData(); 
		}
	}

    // Display by rid

	public void DisplaySpecific(int rid)
	{
		for(Student sref:lobj)
		{
			if(sref.RID==rid)
			{
				sref.DisplayData();
				
			}
		}


	}

	// Display by name

	public void DisplaySpecific(String str)
	{
		for(Student sref:lobj)
		{
			if(str.equals(sref.Name))
			{
				sref.DisplayData();
				break;
			}
		}


	}


	public void DisplayByAd(String adr)
	{
		for(Student sref:lobj)
		{
			if(adr.equals(sref.Address))
			{
				sref.DisplayData();
			}
		}
	}

	public void DisplayByL(int l)
	{
		int z = 1;

		for(Student sref:lobj)
		{	
			if(z<=l)
			{
			  sref.DisplayData();
			}

			else
			{
				break;
			}
		  
		  z++;

		}
	}

	public void DisplayMthn(int age)  // Display content by more than age
	{
		for(Student sref:lobj)
		{
			if(age <(sref.Age))
			{
				sref.DisplayData();
			}
		}
	}

	/*public void Displaylike(int z)       // Display LIKE
	{
		for(Student sref:lobj)
		{
			if(z==(sref.Name.length()))
			{
				sref.DisplayData();
				
			}
		}


	}*/



	public void DeleteSpecific(int rid)
	{
		int index=0;

		for(Student sref:lobj)
		{
			if(sref.RID==rid)
			{
				lobj.remove(index);
				break;
			}

			index++;
		}

	}

	public void DeleteSpecific(String str)
	{
		int index=0;

		for(Student sref:lobj)
		{
			if(sref.Name==str)
			{
				lobj.remove(index);
				break;
			}

			index++;
		}

	}

	public void AggregateMax()
	{
		int iMax=0;
		Student temp = null;

		for(Student sref:lobj)
		{
			if(sref.Salary>iMax)
			{
				iMax = sref.Salary;
				temp = sref;
			}
		}

		System.out.println("Information of student having maximum salary:");
		temp.DisplayData();
	}

	public void AggregateMin()
	{
		int iMin=(lobj.getFirst()).Salary;
		Student temp = lobj.getFirst();

		for(Student sref:lobj)
		{
			if(sref.Salary<iMin)
			{
				iMin = sref.Salary;
				temp = sref;
			}
		}

		System.out.println("Information of student having minimum salary:");
		temp.DisplayData();
	}

	public void AggregateSum()
	{
		long iSum = 0;

		for(Student sref:lobj)
		{
			iSum = iSum + sref.Salary;
		}

		System.out.println("Summation of salary:"+iSum);
		
	}

	public void AverageSum()
	{
		long iSum = 0;

		for(Student sref:lobj)
		{
			iSum = iSum + sref.Salary;
		}

		System.out.println("Average of salary:"+iSum/(lobj.size()));
		
	}


	public void AggregateCount()
	{
		
		System.out.println("No of salary:"+lobj.size());
		
	}


}

