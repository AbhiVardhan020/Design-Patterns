
class Database{

    private static Database database;

    private Database(){

    }

    static Database getInstance(){
        if(database==null){
            database = new Database();
        }
        return database;
    }

}




class SingletonDemo{
    public static void main(String[] args) {

        Database db1;

        db1 = Database.getInstance();

        System.out.println(db1);

        Database db2;

        db2 = Database.getInstance();

        System.out.println(db2);
        
    }
}
