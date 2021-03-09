public class Main {
    public static void main(String[] args) throws Exception {

        Frame frame = new Frame("Login",
                new HorizontalLayout(
                        new VerticalLayout(
                                new Rectangle(new Text("User")),
                                new Rectangle(new Text("Password")),
                                new HorizontalLayout(
                                        new Rectangle(
                                                new Text("Ok")),
                                        new Rectangle(
                                                new Text("Cancel")))),
                        new Frame("Help",
                                new VerticalLayout(
                                        new Text("Please enter login"),
                                        new Text("  and password"),
                                        new Text("Then press Ok button")))));

        char[][] gui = new char[frame.getWidth()][frame.getHeight()];

        frame.calculate();
        frame.draw(gui);
        print(gui);
    }

    public static void print(char[][] arr) {
        for (int i = 0; i < arr[0].length; i++) {
            for (char[] chars : arr) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }
}
