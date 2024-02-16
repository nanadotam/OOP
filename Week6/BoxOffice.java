class Box {
    double width;
    double height;
    double depth;
    }

class BoxDemo {
    public static void main(String args[]) {
        Box mybox = new Box();
        Box box1 = new Box();
        Box box2 = new Box();
        double vol;
        mybox.width = 10;
        mybox.height = 20;
        mybox.depth = 15;
        vol = mybox.width * mybox.height * mybox.depth;
        System.out.println("Volume is " + vol);

        box1.width = 20; box1.height = 30; box1.depth = 10; 
        box2.width = 40; box2.height = 50; box2.depth = 30; 

        System.out.println("PHASE 2");
        double vol1;
        double vol2;

        vol1 = box1.width * box1.height * box1.depth;
        vol2 = box2.width * box2.height * box2.depth;

        if (vol1 > vol2) {
            System.out.println("Box 1 is bigger than Box 2");
        }
        else {
            System.out.println("Box 2 is bigger than Box 1");
        }
    }
}
