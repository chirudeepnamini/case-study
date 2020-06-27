import java.util.*;

import com.dxc.pojo.books;
import com.dxc.pojo.users;
import com.dxc.services.*;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice,status,isadmin;
		Scanner sc=new Scanner(System.in);
	
			IAdminServices admin=new AdminDaoServices();
			status=admin.openconn();
			IUserServices user=new UserServicesImpl();
			
			while(true)
			{
				System.out.println("enter your credentials");
				System.out.println("userid: ");
				int userid=sc.nextInt();
				String password=sc.next();
				isadmin=user.login(userid, password);
				if(isadmin==1)
				{ 
					while(true)
					{
					System.out.println("1.add books");
					System.out.println("2.get list of books");
					System.out.println("3.check balance of a user");
					System.out.println("4.delete a user");
					System.out.println("5.delete a book");
					System.out.println("6.exit");
					choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						int bookid;String author;
						System.out.println("enter bookid");
						bookid=sc.nextInt();
						System.out.println("enter author name");
						author=sc.next();
						admin.addbook(bookid, author,1);
						break;
					case 2:
						List<books> booklist=new ArrayList<books>();
						booklist=admin.getbooks();
						for(books s:booklist)
						{
							s.display();
						}
						break;
					case 3:
						int searchid;
						System.out.println("enter userid");
						searchid=sc.nextInt();
						int balance;
						balance=admin.balance(searchid);
						System.out.println(balance);
						break;
					case 4:
						int delid;
						System.out.println("enter userid");
						delid=sc.nextInt();
						
						admin.delete(delid);
						System.out.println("user deleted");
						break;
					case 5:
						int delbookid;
						System.out.println("enter bookid");
						delbookid=sc.nextInt();
					
						admin.deletebook(delbookid);
						System.out.println("book deleted");
						break;
					case 6:
						break;
					default:
						System.out.println("enter a valid output");
					}
					if(choice==6)
						break;
				}
					
				}
				else if(isadmin==-1)
				{	
					while(true)
					{
						System.out.println("1.get a book");
						System.out.println("2.get books of a author");
						System.out.println("3.check balance");
						System.out.println("4.exit");
						choice=sc.nextInt();
						switch(choice)
						{
						case 1:
							int days;
							System.out.println("enter bookid");
							int bookid;
							bookid=sc.nextInt();
							System.out.println("enter number of days you want the book for");
							days=sc.nextInt();
							user.bookissue(bookid,userid,days);
							break;
						case 2:
							String author;
							System.out.println("enter name of the author");
							author=sc.next();
							List<books> booklist=new ArrayList<books>();
							booklist=user.getbooksbyauthor(author);
							for(books s:booklist)
							{
								s.display();
							}
							break;
						case 3:
							
							int balance;
							balance=user.balance(userid);
							System.out.println(balance);
							break;
						case 4:
							break;
						default:
							System.out.println("enter a valid input");
							
						}
						if(choice==4)
							break;
					}
				
					
				}
				
			}
			
						
			
			
			
			
		
		
		
		
	}

}
