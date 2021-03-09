public class Text extends CalculableElement implements GUIElement {
    private final String text;

    public Text(String text) {
        this.text = text;
        width = getWidth();
        height = getHeight();
    }

    @Override
    public int getWidth() {
        return text.length();
    }

    @Override
    public int getHeight() {
        return 1;
    }

    @Override
    public void calculate() {
        isCalculated = true;
    }

    @Override
    public void draw(char[][] gui) throws Exception {
        if (!isCalculated) {
            throw new Exception("Frame not calculated!");
        }

        int topY = y;
        int leftX = x;

        char[] chArr = text.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            gui[i + leftX][topY] = chArr[i];
        }
    }

    @Override
    protected void setWidth(int width) {
        this.width = width;
    }

    @Override
    protected void setHeight(int height) {
        this.height = height;
    }
}
