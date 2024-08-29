import java.util.Scanner;
class OnlineBankingSystem {
    Scanner sc = new Scanner (System.in);
    private String UserName;
    private String Password;
    private String AccountNumber;
    private String AccountHolName;
    private int InitialAmount = 500;

    public void displayMenu(){
        int choice1;
        do {
            System.out.println("Select Your Choice : \n1) create Account \n2) login \n3) Exit ");
            System.out.print("Enter Your Choice : ");
            choice1 = sc.nextInt();
            sc.nextLine();
            switch (choice1) {
                case 1:
                    CreateAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.print("Exiting......... ");
                    break;
            }
        }while(choice1!=3);
    }
    public void CreateAccount() {
        System.out.println("Welcome to the OnlineBankingSystem !");
        System.out.println("Create Your new Account ");
        System.out.println("Enter your User name : ");
        UserName = sc.nextLine();
        System.out.println("Enter your password : ");
        Password = sc.nextLine();
        System.out.println("Enter your Account Number : ");
        AccountNumber = sc.nextLine();
        System.out.println("Enter your Account Holder Name : ");
        AccountHolName = sc.nextLine();
        System.out.println("Your Account is successfully created ");
        login();
    }
        public void login () {
            System.out.println("Now login to your Account");
            System.out.print("Enter your Username : ");
            String ExistingUserName = sc.nextLine();
            System.out.print("Enter your Password : ");
            String ExistingPassword = sc.nextLine();

            if (ExistingUserName.equals(UserName) && ExistingPassword.equals(Password)) {
                System.out.print("Your are Successfully login ");
                UserOperation();
            } else {
                System.out.println("YOur Have Enter the invalid Username and password ");
                System.out.println("Try Again to Enter the Username and Password");
                login();
            }
        }
        public void UserOperation() {
            int choice ;
            do {
                System.out.println("Select your choice : \n 1) CheckBalance \n 2) WithdrawMoney \n 3) DepositMoney \n 4) Manage Profile \n 5) Exit ");
                System.out.print("Enter your choice : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        CheckBalance();
                        break;
                    case 2:
                        WithdrawMoney();
                        break;
                    case 3:
                        DepositMoney();
                        break;
                    case 4 :
                        ManageInformation();
                        break;
                    case 5:
                        System.out.print("Exiting....");
                        break;
                    default:
                        System.out.print("Your Have Enter the Invalid choice ");
                        UserOperation();
                }
            }while( choice !=5);

        }

        public void CheckBalance () {
            System.out.println("Your Balance is : " + InitialAmount);
            UserOperation();

        }
        public void WithdrawMoney () {
            System.out.print("Enter your Withdraw Amount : ");
            int WithdrawAmount = sc.nextInt();
            if(WithdrawAmount < 0){
                System.out.print("You have Enter the invalid Amount ");
            }
            else {
                if (WithdrawAmount > InitialAmount) {
                    System.out.println("Your have insufficient Balance ");
                } else {
                    InitialAmount -= WithdrawAmount;
                    System.out.println("Your Money is Successfully Withdraw ");
                }
            }
            UserOperation();
        }
        public void DepositMoney () {
            int DepositAmount;
            System.out.print("Enter your Deposit Amount: ");
            DepositAmount = sc.nextInt();
            if (DepositAmount < 0) {
                System.out.print("You have Enter the invalid Amount");
            } else {
                InitialAmount += DepositAmount;
                System.out.println("Your Money is successfully Deposit ");
                UserOperation();
            }
        }

        public void ManageInformation(){
        System.out.println("Here You Are Manage Your Account details ");
        System.out.println("Account Number is : " + AccountNumber);
        System.out.println("Account Holder Name is : " + AccountHolName);
            UserOperation();
    }

    public static void main (String [] args ){
    OnlineBankingSystem obj = new OnlineBankingSystem();
    obj.displayMenu();
    }
}
