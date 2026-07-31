

class Database{

    private static Database database;


    private Database(){}

    // Not thread safe (multiple concurrent threads may create multiple objects)
    public static Database getInstance(){
        if(database==null){
            database = new Database();
        }

        return database;
    }

    // Thread safe (only one thread can access first and only one object is created)
    public static synchronized Database getInstance1(){
        if(database==null){
            database = new Database();
        }

        return database;
    }

    
    // Faster than previous method as lock is acquired only once
    public static Database getInstance2(){
        if(database==null){
            synchronized(Database.class){
                if(database==null){
                    database = new Database();
                }
            }
        }
        return database;
    }

    // Uses static class, giving lazy initialization without synchronization
    private static class Holder{
        private static final Database INSTANCE = new Database();
    }

    public Database getInstance3(){
        return Holder.INSTANCE;
    }

}


class SingletonVersions{

    public static void main(String[] args) {
        
        Database d1 = Database.getInstance();

        System.out.println(d1);

        
        Database d2 = Database.getInstance();

        System.out.println(d2);
    }

}