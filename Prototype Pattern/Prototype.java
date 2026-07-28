

interface EnemyPrototype{

    Enemy clone();

}

class Enemy implements EnemyPrototype{

    private final String type;
    private int health;
    private final double speed;
    private final boolean armored;
    private final String weapon;

    public Enemy(String type, int health, double speed, boolean armored, String weapon){
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.armored = armored;
        this.weapon = weapon;
    }

    @Override
    public Enemy clone(){
        return new Enemy(type, health, speed, armored, weapon);
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getHealth(){
        return this.health;
    }

    @Override
    public String toString(){
        return "Enemy Details : [\n\tType : "+type+",\n\tHealth : "+health+",\n\tSpeed : "+speed+",\n\tArmored : "+armored+",\n\tWeapon : "+weapon+"\n]\n";
    }

}


public class Prototype {

    public static void main(String[] args) {

        Enemy flyingEnemy = new Enemy("Flying", 150, 50, false, "Laser");
        Enemy armoredEnemy = new Enemy("Armored", 200, 35, true, "Rifle");


        Enemy e1 = flyingEnemy.clone();
        e1.setHealth(e1.getHealth()-10);
        System.out.println(e1);

        Enemy e2 = armoredEnemy.clone();
        e2.setHealth(e2.getHealth()-20);
        System.out.println(e2);

    }
    

}
