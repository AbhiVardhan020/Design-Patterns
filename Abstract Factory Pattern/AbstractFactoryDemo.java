

interface GUIFactory{
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new WindowsButton();
    }
    @Override
    public Checkbox createCheckbox(){
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory{
    @Override
    public Button createButton(){
        return new MacButton();
    }
    @Override
    public Checkbox createCheckbox(){
        return new MacCheckbox();
    }
}

interface Button{
    void onClick();
}

interface Checkbox{
    void onCheck();
}

class WindowsButton implements Button{
    @Override
    public void onClick(){
        System.out.println("You clicked a Windows Button");
    }
}

class WindowsCheckbox implements Checkbox{
    @Override
    public void onCheck(){
        System.out.println("You checked a Windows Checkbox");
    }
}

class MacButton implements Button{
    @Override
    public void onClick(){
        System.out.println("You clicked a Mac Button");
    }
}

class MacCheckbox implements Checkbox{
    @Override
    public void onCheck(){
        System.out.println("You checked a Mac Checkbox");
    }
}


class Client{
    GUIFactory factory;

    Client(GUIFactory fact){
        this.factory = fact;
    }

    void execute(){
        Button button = this.factory.createButton();
        Checkbox checkbox = this.factory.createCheckbox();
        button.onClick();
        checkbox.onCheck();
    }
}



class AbstractFactoryDemo{
    public static void main(String[] args) {
        
        GUIFactory factory;

        String os = "Windows";

        if (os.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacFactory();
        }

        Client client = new Client(factory);
        client.execute();
        
    }
}