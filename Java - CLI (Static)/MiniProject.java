/*
	Student BioData Record Management System
	Jainam Barbhaya IT 3rd Sem
*/

// Importing Libraries
	import java.util.*;
	import java.time.*;
	import java.text.*;
	import javax.swing.*;  
	import java.time.format.*;
	import java.util.concurrent.*;
	import UserDefinedException.*;

interface ColorCode
{	
    public static String ANSI_RESET = "\u001B[0m";
    public static String ANSI_RED = "\u001B[31m";
    public static String ANSI_GREEN = "\u001B[32m";
    public static String ANSI_YELLOW = "\u001B[33m";
    public static String ANSI_BLUE = "\u001B[34m";
    public static String ANSI_PURPLE = "\u001B[35m";
    public static String ANSI_CYAN = "\u001B[36m";
    public static String ANSI_BOLD = "\u001B[1m";
    public static String ANSI_UNBOLD = "\u001B[21m";
    public static String ANSI_BLINK = "\u001B[5m"; 
}

class Login implements ColorCode
{
	Scanner sc = new Scanner(System.in);

	private String adminId, adminPass;

	Login()
	{

		System.out.println();
		System.out.println();

		System.out.println(ANSI_BOLD + ANSI_YELLOW + "\t\t\t\tAdmin Login.....\n" + ANSI_UNBOLD + ANSI_RESET);
		System.out.print(ANSI_BLUE + ANSI_BOLD + "\t\t\t\t[?]" + ANSI_RESET  + ANSI_UNBOLD +  " Enter ID: ");
		System.out.print(ANSI_RED);
		adminId = sc.next();
		System.out.print(ANSI_RESET);

		System.out.print(ANSI_BLUE + ANSI_BOLD + "\t\t\t\t[?]" + ANSI_RESET + ANSI_UNBOLD + " Enter Password: ");
		System.out.print(ANSI_RED);
		adminPass = sc.next();
		System.out.print(ANSI_RESET);

		while(true)
		{
			if(adminId.equals("admin") && adminPass.equals("admin"))
			{
				System.out.print("\033[H\033[2J");  
				System.out.flush(); 

				System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n\t\t\t\t\t\t\t\t\tAdmin Login....." + ANSI_GREEN + ANSI_BLINK + "success"+ ANSI_UNBOLD + ANSI_RESET);
				try
				{
					Thread.sleep(5000);
				}
				catch(InterruptedException e){}

				System.out.print("\033[H\033[2J");  
				System.out.flush(); 
				break;
			}
			else if(adminId != "admin" && adminPass != "admin")
			{
				try
				{
					if(adminId != "admin" && adminPass != "admin")
					{
						System.out.print("\033[H\033[2J");  
						System.out.flush(); 

						System.out.println(ANSI_BOLD + ANSI_YELLOW + "\n\t\t\t\t\t\t\t\t\t\t\t\tAdmin Login....." + ANSI_RED + ANSI_BLINK + "failed"+ ANSI_UNBOLD + ANSI_RESET);
						throw new InvalidInputException(ANSI_RED + ANSI_BOLD + ANSI_BLINK + "\n\t\t\t\t\t\t\t\t[!]" + ANSI_UNBOLD + ANSI_RESET + " Please enter valid id or password " + ANSI_RED + ANSI_BOLD + ANSI_BLINK + "[!]" + ANSI_RESET + ANSI_RESET);
					}
				}
				catch(InvalidInputException e)
				{
					System.out.println();
				}
				System.out.println(ANSI_BOLD + ANSI_YELLOW + "\t\t\t\tAdmin Login.....\n" + ANSI_UNBOLD + ANSI_RESET);
				System.out.print(ANSI_BLUE + ANSI_BOLD + "\t\t\t\t[?]" + ANSI_RESET  + ANSI_UNBOLD +  " Enter ID: ");
				System.out.print(ANSI_RED);
				adminId = sc.next();
				System.out.print(ANSI_RESET);

				System.out.print(ANSI_BLUE + ANSI_BOLD + "\t\t\t\t[?]" + ANSI_RESET + ANSI_UNBOLD + " Enter Password: ");
				System.out.print(ANSI_RED);
				adminPass = sc.next();
				System.out.print(ANSI_RESET);
			}
		}
	}
}
class StudentData implements ColorCode
{
	Scanner sc = new Scanner(System.in);

//Create Data Fields for students
	private char typeOfAdmission, selectBranch;
	private String contactNo1, contactNo2, contacts,emailId, dateOfBirth, dateOfAdmission, branch,fname,mname,lname, fullName, currentAddress, type, area, state, city, sem1, sem2, sem3, sem4, sem5, sem6, fsem1, fsem2, fsem3, fsem4, fsem5, fsem6;
	private float sscMarks, hscMarks;

// Start of addStudent()
	void addStudent() throws Exception
	{
		System.out.println();
		System.out.println();

		System.out.println(ANSI_BOLD +ANSI_BLUE  + "[+]"+ ANSI_RESET + ANSI_GREEN + " Insert:" + ANSI_RESET);
		// Input the year of admission
		/*
		while(true)
		{
			DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd/mm/yyyy"); // the date format i want

			System.out.println("Enter year of admission: ");
			dateOfAdmission = sc.next();

			if(d2.compareTo(d1) > 0)
			{
				System.out.println("Please enter a valid year");
			}
			else
			{
				break;
			}
		}
		*/
		// Input the type of admission
		System.out.println();
		while(true)
		{
			System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW +  "Enter type of admission" + ANSI_RESET + "\n\t1. First Year\t2. Direct Second Year\n\tChoose: ");
			typeOfAdmission = sc.next().charAt(0);

			if(typeOfAdmission == '1')
			{
				type = "First Year";
				break;
			}
			else if(typeOfAdmission == '2')
			{
				type = "Direct Second Year";
				break;
			}
			else
			{
				System.out.println(ANSI_BOLD + ANSI_RED + "[!] " + ANSI_RESET + ANSI_UNBOLD + "Please enter a valid type of admission"+ ANSI_RED + ANSI_BOLD + " [!]" + ANSI_RESET + ANSI_UNBOLD );
			}
		}
		System.out.println();
		// Input the branch
		while(true)
		{
			int selectBranch;
			System.out.println(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Select your branch" + ANSI_RESET);
			System.out.print("\t1. Civil Engineering (CIVIL)\t\t3. Chemical Engineering (CHEM)\t\t\t\t5. Information Technology (IT)\n");
			System.out.print("\t2. Mechanical Engineering (MECH)\t4. Electronics & Telecommunication Engineering (EXTC)\t6. Computer Science Engineering (CSE)\n\tChoose: ");
			selectBranch = sc.next().charAt(0);

			if(selectBranch == '1')
			{
				branch = "CIVIL";
				break;
			}
			else if(selectBranch == '2')
			{
				branch = "MECH";
				break;
			}
			else if(selectBranch == '3')
			{
				branch = "CHEM";
				break;
			}
			else if(selectBranch == '4')
			{
				branch = "EXTC";
				break;
			}
			else if(selectBranch == '5')
			{
				branch = "IT";
				break;
			}
			else if(selectBranch == '6')
			{
				branch = "CSE";
				break;
			}
			else
			{
				System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid option" + ANSI_RED + " [!]" + ANSI_RESET);
			}
		}

		System.out.println();
		System.out.println();

		// Enter your name details
		System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW +  "Enter your first name: " + ANSI_RESET);
		fname = sc.next();
		System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW +  "Enter your middle name: " + ANSI_RESET);
		mname = sc.next();
		System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW +  "Enter your last name: " + ANSI_RESET);
		lname = sc.next();

		fullName = fname + " " + mname + " " + lname;

		System.out.println();
		System.out.println();

		// Enter your email id
		EMAIL:
		while(true)
		{
			System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter your email id: " + ANSI_RESET);
			emailId = sc.next();

			for(int i = 0; i < emailId.length(); i++)
			{
				if(emailId.charAt(i) == '@')
				{
					if(emailId.substring(i).equals("@gmail.com"))
					{
						break EMAIL;	
					}
					else if(emailId.substring(i).equals("@yahoo.com"))
					{
						break EMAIL;
					}
					else if(emailId.substring(i).equals("@microsoft.com"))
					{
						break EMAIL;
					}
				}
			}
			System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid email id" + ANSI_RED + " [!]" + ANSI_RESET);
		}

		System.out.println();
		System.out.println();

		// Entering contact number
		while(true)
		{
			while(true)
			{
				System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter Contact 1 (enter 'null' for no entry): " + ANSI_RESET);
				contactNo1 = sc.next();

				if(contactNo1.equals("null"))
				{
					contactNo1 = ANSI_CYAN + "null" + ANSI_RESET;
					break;
				}
				else if(contactNo1.length() != 10 || contactNo1.length() < 0 || contactNo1.length() > 10 )
				{
					System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid contact number" + ANSI_RED + " [!]" + ANSI_RESET);
				}
				else
				{
					break;
				}
			}
			while(true)
			{
				System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter Contact 2 (enter 'null' for no entry): " + ANSI_RESET);
				contactNo2 = sc.next();

				if(contactNo2.equals("null"))
				{
					contactNo2 = ANSI_CYAN + "null" + ANSI_RESET;
					break;
				}
				else if(contactNo2.length() != 10 || contactNo2.length() < 0 || contactNo2.length() > 10 )
				{
					System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid contact number" + ANSI_RED + " [!]" + ANSI_RESET);
				}
				else
				{
					break;
				}
			}
			try
			{	
				if(contactNo1.equals("null") && contactNo2.equals("null"))
				{
					throw new InvalidInputException(ANSI_RED + "[!] " + ANSI_RESET + "Please enter atleast 1 contact info" + ANSI_RED + " [!]" + ANSI_RESET);
				}
				else 
				{
					break;
				}
			}
			catch(InvalidInputException e){}
		}
		
		System.out.println();
		System.out.println();

		// Enter your date of birth
		while(true)
		{
			System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter your date of birth in (dd/mm/yyyy): " + ANSI_RESET);
			dateOfBirth = sc.next();

			try
			{
				Date dob = new SimpleDateFormat("dd/mm/yyyy").parse(dateOfBirth);
				break;
			}
			catch(ParseException e)
			{
				System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid date format" + ANSI_RED + " [!]" + ANSI_RESET);
			}
		}

		System.out.println();
		System.out.println();

		// Enter your address
		System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter your area: " + ANSI_RESET);
		area = sc.next();
		System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter your city: " + ANSI_RESET);
		city = sc.next();
		System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter your state: " + ANSI_RESET);
		state = sc.next();

		currentAddress = area + " " + city + " " + state;
		System.out.println();
		System.out.println();

		// Enter your grade 10th / 12th percentage
		PERCENTAGE:
		while(true)
		{
			if(typeOfAdmission == '1')
			{
				System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter grade 10th percentage: " + ANSI_RESET);
				sscMarks = sc.nextFloat();

				if(sscMarks > 100.0)
				{
					System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
				}
				else if(sscMarks < 23.0)
				{
					System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Not eleigible for admission" + ANSI_RED + " [!]" + ANSI_RESET);
				}
				else
				{
					break;
				}
			}
			else if(typeOfAdmission == '2')
			{
				while(true)
				{
					System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter grade 10th percentage: " + ANSI_RESET);
					sscMarks = sc.nextFloat();

					if(sscMarks > 100.0)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else if(sscMarks < 23.0)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Not eleigible for admission" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else
					{
						break;
					}
				}

				while(true)
				{
					System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter grade 12th percentage: " + ANSI_RESET);
					hscMarks = sc.nextFloat();

					if(hscMarks > 100.0)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else if(hscMarks < 23.0)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Not eleigible for admission" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else
					{
						break PERCENTAGE;
					}
				}
			}
		}

		System.out.println();
		System.out.println();

	// Enter diploma marks
		SEMESTER:
		while(true)
		{
			while(true)
			{
				System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter semester 1 percentage (enter 'null' for no value): " + ANSI_RESET);
				sem1 = sc.next();

				if(sem1.equals("null"))
				{
					sem1 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem2 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem3 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem4 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem5 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem6 = ANSI_CYAN +  "null" + ANSI_RESET;
					fsem1 = sem1;
					fsem2 = sem2;
					fsem3 = sem3;
					fsem4 = sem4;
					fsem5 = sem5;
					fsem6 = sem6;
					break SEMESTER;
				}
				else if(Float.parseFloat(sem1) > 100.0f)
				{
					System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
				}
				else if(Float.parseFloat(sem1) < 33.0f)
				{
					String sem1 = ANSI_RED + "KT" + ANSI_RESET;
					sem2 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem3 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem4 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem5 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem6 = ANSI_CYAN +  "null" + ANSI_RESET;
					sem6 = ANSI_CYAN +  "null" + ANSI_RESET;
					fsem1 = sem1;
					fsem2 = sem2;
					fsem3 = sem3;
					fsem4 = sem4;
					fsem5 = sem5;
					fsem6 = sem6;
					System.out.println(ANSI_RED + "[!] "+ ANSI_RESET + "You cannot attempt semester 2 " + ANSI_RED + "[!]" + ANSI_RESET);
					break SEMESTER;
				}
				else if(Float.parseFloat(sem1) >= 33.0 && Float.parseFloat(sem1) <= 100.0)
				{
					fsem1 = sem1;
					break;
				}
				else
				{
					System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid input" + ANSI_RED + " [!]" + ANSI_RESET);
				}
			}
			while(true)
			{
					System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter semester 2 percentage (enter 'null' for no value): " + ANSI_RESET);
					sem2 = sc.next();

					if(sem2.equals("null"))
					{
						sem2 = ANSI_CYAN + "null" + ANSI_RESET;
						sem3 = ANSI_CYAN + "null" + ANSI_RESET;
						sem4 = ANSI_CYAN + "null" + ANSI_RESET;
						sem5 = ANSI_CYAN + "null" + ANSI_RESET;
						sem6 = ANSI_CYAN + "null" + ANSI_RESET;
						fsem2 = sem2;
						fsem3 = sem3;
						fsem4 = sem4;
						fsem5 = sem5;
						fsem6 = sem6;
						break SEMESTER;
					}
					else if(Float.parseFloat(sem2) > 100.0f)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else if(Float.parseFloat(sem2) < 33.0f)
					{
						String sem2 = ANSI_RED + "KT" + ANSI_RESET;
						sem3 = ANSI_CYAN + "null" + ANSI_RESET;
						sem4 = ANSI_CYAN + "null" + ANSI_RESET;
						sem5 = ANSI_CYAN + "null" + ANSI_RESET;
						sem6 = ANSI_CYAN + "null" + ANSI_RESET;
						System.out.println(ANSI_RED + "[!] "+ ANSI_RESET + "You cannot attempt semester 3 " + ANSI_RED + "[!]" + ANSI_RESET);
						fsem2 = sem2;
						fsem3 = sem3;
						fsem4 = sem4;
						fsem5 = sem5;
						fsem6 = sem6;
						break SEMESTER;
					}
					else if(Float.parseFloat(sem2) >= 33.0 && Float.parseFloat(sem2) <= 100.0)
					{
						fsem2 = sem2;
						break;
					}
					else
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid input" + ANSI_RED + " [!]" + ANSI_RESET);
					}
			}
			while(true)
			{
					System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter semester 3 percentage (enter 'null' for no value): " + ANSI_RESET);
					sem3 = sc.next();

					if(sem3.equals("null"))
					{
						sem3 = ANSI_CYAN + "null" + ANSI_RESET;
						sem4 = ANSI_CYAN + "null" + ANSI_RESET;
						sem5 = ANSI_CYAN + "null" + ANSI_RESET;
						sem6 = ANSI_CYAN + "null" + ANSI_RESET;
						fsem3 = sem3;
						fsem4 = sem4;
						fsem5 = sem5;
						fsem6 = sem6;
						break SEMESTER;
					}
					else if(Float.parseFloat(sem3) > 100.0f)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else if(Float.parseFloat(sem3) < 33.0f)
					{
						String sem3 = ANSI_RED + "KT" + ANSI_RESET;
						sem4 = ANSI_CYAN + "null" + ANSI_RESET;
						sem5 = ANSI_CYAN + "null" + ANSI_RESET;
						sem6 = ANSI_CYAN + "null" + ANSI_CYAN;
						fsem3 = sem3;
						fsem4 = sem4;
						fsem5 = sem5;
						fsem6 = sem6;
						System.out.println(ANSI_RED + "[!] "+ ANSI_RESET + "You cannot attempt semester 4 " + ANSI_RED + "[!]" + ANSI_RESET);
						break SEMESTER;
					}
					else if(Float.parseFloat(sem3) >= 33.0 && Float.parseFloat(sem3) <= 100.0)
					{
						fsem3 = sem3;
						break;
					}
					else
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid input" + ANSI_RED + " [!]" + ANSI_RESET);
					}
			}
			while(true)
			{
					System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter semester 4 percentage (enter 'null' for no value): " + ANSI_RESET);
					sem4 = sc.next();

					if(sem4.equals("null"))
					{
						sem4 = ANSI_CYAN + "null"+ ANSI_RESET;
						sem5 = ANSI_CYAN + "null"+ ANSI_RESET;
						sem6 = ANSI_CYAN + "null"+ ANSI_RESET;
						fsem4 = sem4;
						fsem5 = sem5;
						fsem6 = sem6;
						break SEMESTER;
					}
					else if(Float.parseFloat(sem4) > 100.0f)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else if(Float.parseFloat(sem4) < 33.0f)
					{
						String sem4 = ANSI_RED + "KT" + ANSI_RESET;
						String sem5 = ANSI_CYAN + "null"+ ANSI_RESET;
						sem6 = ANSI_CYAN + "null"+ ANSI_RESET;
						fsem4 = sem4;
						fsem5 = sem5;
						fsem6 = sem6;
						System.out.println(ANSI_RED + "[!] "+ ANSI_RESET + "You cannot attempt semester 5 " + ANSI_RED + "[!]" + ANSI_RESET);
						break SEMESTER;
					}
					else if(Float.parseFloat(sem4) >= 33.0 && Float.parseFloat(sem4) <= 100.0)
					{
						fsem4 = sem4;
						break;
					}
					else
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid input" + ANSI_RED + " [!]" + ANSI_RESET);
					}
			}
			while(true)
			{
					System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter semester 5 percentage (enter 'null' for no value): " + ANSI_RESET);
					sem5 = sc.next();

					if(sem5.equals("null"))
					{
						sem5 = ANSI_CYAN + "null" + ANSI_RESET;
						sem6 = ANSI_CYAN + "null" + ANSI_RESET;
						fsem5 = sem5;
						fsem6 = sem6;
						break SEMESTER;
					}	
					else if(Float.parseFloat(sem5) > 100.0f)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else if(Float.parseFloat(sem5) < 33.0f)
					{
						String sem5 = ANSI_RED + "KT" + ANSI_RESET;
						String sem6 = ANSI_CYAN + "null" + ANSI_RESET;
						fsem5 = sem5;
						fsem6 = sem6;
						System.out.println(ANSI_RED + "[!] "+ ANSI_RESET + "You cannot attempt semester 6 " + ANSI_RED + "[!]" + ANSI_RESET);
						break SEMESTER;
					}
					else if(Float.parseFloat(sem5) >= 33.0 && Float.parseFloat(sem5) <= 100.0)
					{
						fsem5 = sem5;
						break;
					}
					else
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid input" + ANSI_RED + " [!]" + ANSI_RESET);
					}
			}
			while(true)
			{
					System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter semester 6 percentage (enter 'null' for no value): " + ANSI_RESET);
					sem6 = sc.next();

					if(sem6.equals("null"))
					{
						sem6 = ANSI_CYAN + "null" + ANSI_RESET;
						fsem6 = sem6;
						break SEMESTER;
					}
					if(Float.parseFloat(sem6) > 100.0f)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid percentage" + ANSI_RED + " [!]" + ANSI_RESET);
					}
					else if(Float.parseFloat(sem6) < 33.0f)
					{
						String sem6 = ANSI_RED + "KT" + ANSI_RESET;
						fsem6 = sem6;
						break SEMESTER;
					}
					else if(Float.parseFloat(sem6) >= 33.0 && Float.parseFloat(sem6) <= 100.0)
					{
						fsem6 = sem6;
						break SEMESTER;
					}
					else
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid input" + ANSI_RED + " [!]" + ANSI_RESET);
					}
			}
		}
	}
// End of addStudent()

// attribute start
	static void attributes()
	{
		System.out.println(ANSI_YELLOW + "TYPE\t\t\tBRANCH\t\tNAME\t\t\tDATE OF BIRTH \tEMAIL ID\t\tCONTACT N0 \tADDRESS\t\tGRADE 10%   GRADE 12%    Sem 1    Sem 2    Sem 3    Sem 4    Sem 5   Sem 6" + ANSI_RESET);
	}
//attribute end

// Start of getStudent()
	void getStudent()
	{
		System.out.print(type+"\t"+branch+"\t" + fullName + "\t      "+dateOfBirth+"\t"+emailId+"\t"+contactNo1+"\t"+sscMarks+"\t"+hscMarks+"  "+fsem1+"  "+fsem2+"  "+fsem3+"  "+fsem4+"  "+fsem5+"  "+fsem6);
	 	System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+contactNo2+"\t");
	 	System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+area+",");
	 	System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+city+",");
	 	System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+state+",");
	}
// End of getStuent

//Start of searchStudent()
	static void searchStudent(StudentData sd[], int studentCount, int studentId) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int found = 0;

		System.out.println(ANSI_BOLD + ANSI_BLUE + "[+] " + ANSI_RESET + ANSI_GREEN + "Search:" + ANSI_RESET);
		System.out.print("1. Branch Code\n2. Name\n3. Area\n4. Percentage\nChoose: ");
		int searchType = sc.nextInt();

		switch(searchType)
		{
		
		case 1:
			{
			System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter branch code to be searched: "+ ANSI_RESET);
			String searchBranchCode = sc.next();

			StudentData.attributes();

			for(int i=0; i<studentCount; i++)
			{
				if(sd[i].branch.equals(searchBranchCode))
				{
					sd[i].getStudent();
					found++;
				}	
			}
			break;
		}

		case 2:
			System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter the name to  be searched: "+ ANSI_RESET);
			String searchName = sc.next();

			StudentData.attributes();

			for(int i=0; i<studentCount; i++)
			{
				if(sd[i].fname.equals(searchName))
				{
					sd[i].getStudent();
					found++;
				}
			}
			break;

		case 3:
			System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter the area to  be searched: "+ ANSI_RESET);
			String searchArea = sc.next();

			StudentData.attributes();

			for(int i=0; i<studentCount; i++)
			{
				if(sd[i].area.equals(searchArea))
				{
					sd[i].getStudent();
					found++;
				}
			}
			break;

		case 4:
				System.out.print(ANSI_BLUE + "[*] " + ANSI_RESET + ANSI_YELLOW + "Enter SSC percentage to be searched: "+ ANSI_RESET);
				float searchPercent = sc.nextFloat();

				StudentData.attributes();

				for(int i=0; i<studentCount; i++)
				{
					if(sd[i].sscMarks == searchPercent)
					{
						sd[i].getStudent();
						found++;
					}
				}
				break;

		default:
			System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid input" + ANSI_RED + " [!]" + ANSI_RESET);
		}

		if(found==0)
		{
			System.out.println(ANSI_RED+"[!] " + ANSI_RESET + "No records found"+ ANSI_RED + " [!]"+ ANSI_RESET);
		}
	}
// End of searchStudent()

// Start of sortStudent()

	void sortStudent(StudentData sd[], int studentCount, int studentId)
	{
		System.out.println(ANSI_BLUE + "[+] " + ANSI_RESET + ANSI_GREEN + "Sort: \n" + ANSI_RESET);
		System.out.println("1. Name\t2. SSC/HSC Percentage");
		System.out.print("Choose: ");
		char sortingType = sc.next().charAt(0);

		switch(sortingType)
		{
		case '1':
			{
				String s[] = new String[studentCount];

				for(int i=0;i<studentCount;i++)
				{
					s[i] = sd[i].fullName;
				}

				for(int i=0; i<studentCount; i++)
				{
					for(int j=i+1; j<studentCount; j++)
					{
						if(s[i].compareTo(s[j])>0)
						{
							String temp=s[j];
							s[j]=s[i];
							s[i]=temp;
						}
					}
				}
				for(int i = 0; i<studentCount; i++)
				{
					for(int j=0;j<studentCount;j++)
					{
						if(s[i] == sd[j].fullName)
						{
							sd[j].getStudent();
						}
					}
				}
			}
			break;

		case '2':
			{
				float s[] = new float[studentCount];

				for(int i=0;i<studentCount;i++)
				{
					s[i] = sd[i].sscMarks;
				}

				for(int i=0; i<studentCount; i++)
				{
					for(int j=i+1; j<studentCount; j++)
					{
						if(s[i]<=s[j])
						{
							float temp=s[j];
							s[j]=s[i];
							s[i]=temp;
						}
					}
				}
				for(int i = 0; i<studentCount; i++)
				{
					for(int j=0;j<studentCount;j++)
					{
						if(s[i] == sd[j].sscMarks)
						{
							sd[j].getStudent();
						}
					}
				}
			}
			break;

		default:
			{
				System.out.println(ANSI_RED + "[!] " + ANSI_RESET +  "Please enter a valid choice " + ANSI_RED + "[!]" + ANSI_RESET);
			}
		}
	}
// End of sortStudent()
}

/* Main Class Starts From Here */

public class MiniProject implements ColorCode
{
	public static void main(String args[]) throws Exception
	{
		System.out.print("\033[H\033[2J");  
		System.out.flush();
		
		Scanner sc = new Scanner(System.in);

		Login l = new Login();

		StudentData sd[] = new StudentData[1000];

		int studentCount = 0;
		int studentId = 0;
		int i;

		while(true)
		{
			char choice;
			System.out.println(ANSI_BOLD + ANSI_CYAN + "\n\n\t\t\t\t\t\t\t\t[#] " + ANSI_UNBOLD + ANSI_RESET + ANSI_PURPLE + "Enter the operations to be performed on data\n" + ANSI_RESET);
			System.out.println("\t\t\t\t\t\t\t\t\t1. Insert\t2. Search");
			System.out.println("\t\t\t\t\t\t\t\t\t3. Sort\t\t4. Count");
			System.out.println("\t\t\t\t\t\t\t\t\t5. Display\t6. Log Out");
			System.out.print("\t\t\t\t\t\t\t\t\t\tChoose: ");
			choice = sc.next().charAt(0);

			System.out.print("\033[H\033[2J");  
			System.out.flush(); 

			switch(choice)
			{
				case '1': // Insert
				{
					sd[studentId] = new StudentData();
					sd[studentId].addStudent();
					studentId++;
					studentCount++;
					System.out.println();
					System.out.println(ANSI_GREEN + "[~] " + ANSI_RESET + "1 Record Inserted");
					break;
				}
				case '2': // Search
				{
					StudentData.searchStudent(sd, studentCount, studentId);
					break;
				}
				case '3': // Sort
				{
					if(studentCount == 0)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "No student data available"+ ANSI_RED +" [!]"+ ANSI_RESET);
					}
					else
					{
						for(i=0; i<studentCount; i++)
						{
						
							sd[i].sortStudent(sd, studentCount, studentId);
						}
					}
					break;
				}
				case '4': // Total
				{
					System.out.println(ANSI_GREEN + "\n\n\n\n\n\n[~] " + ANSI_RESET + "Total Students Record: " + studentCount);
					break;
				}
				case '5': // Diaplay all
				{
					if(studentCount == 0)
					{
						System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "No student data available"+ ANSI_RED +" [!]"+ ANSI_RESET);
					}
					else
					{
						StudentData.attributes();
						for(i=0; i<studentCount; i++)
						{
							sd[i].getStudent();
						}
					}
					break;
				}
				case '6': // Logout
				{
					System.out.println(ANSI_BOLD + ANSI_YELLOW + "\t\t\t\t\t\t\t\t\t\t\tAdmin Log Out....." + ANSI_RESET + ANSI_BLINK + ANSI_GREEN +"success" + ANSI_RESET);
					try
					{
						Thread.sleep(5000);
					}
					catch(InterruptedException e){}
					System.exit(0);
				}
				default:
				{
					System.out.println(ANSI_RED + "[!] " + ANSI_RESET + "Please enter a valid choice " + ANSI_RED +  " [!]" + ANSI_RESET);
				}
			}
		}
	}
}

/*
References:
1. https://gist.github.com/mgumiero9/665ab5f0e5e7e46cb049c1544a00e29f // Color Codes Reference
2. My java professor Manish Sir
*/