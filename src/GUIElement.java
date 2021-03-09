public interface GUIElement {
    int getWidth();
    int getHeight();
    void calculate();
    void draw(char[][] gui) throws Exception;
}
