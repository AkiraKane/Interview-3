package question3_10;

public abstract class Animal {
    private int order;
    protected String name;
    
    public Animal(String n){
        name = n;
    }
    
    public abstract String name();
    
    public void setOrder(int order) {
        this.order = order;
    }
    
    public int getOrder() {
        return this.order;
    }
    
    public boolean isOldThan(Animal a){
        return this.order < a.getOrder();
    }
}
