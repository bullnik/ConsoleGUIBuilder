public class Frame extends CalculableElement implements Container {
    private final String title;
    private final CalculableElement nested;

    public Frame(String title, CalculableElement nested) {
        this.title = title;
        this.nested = nested;
        width = getWidth();
        height = getHeight();
    }

    @Override
    public void calculate() {
        nested.x = x + 2;
        nested.y = y + 1;
        nested.calculate();
        isCalculated = true;
    }

    @Override
    public int getWidth() {
        return nested.getWidth() + 4;
    }

    @Override
    public int getHeight() {
        return nested.getHeight() + 2;
    }

    @Override
    public void draw(char[][] gui) throws Exception {
        if (!isCalculated) {
            throw new Exception("Frame not calculated!");
        }

        if (getWidth() < title.length() + 6) {
            throw new Exception("Title too big");
        }

        nested.draw(gui);

        //draw frame
        int topY = y;
        int bottomY = topY + height - 1;
        int leftX = x;
        int rightX = leftX + width - 1;

        //top
        gui[leftX][topY] = '╔';
        gui[leftX + 1][topY] = '═';
        char[] chArr = title.toCharArray();
        for (int i = 0; i < chArr.length; i++) {
            gui[leftX + 3 + i][topY] = chArr[i];
        }
        for (int i = leftX + chArr.length + 4; i < rightX; i++) {
            gui[i][topY] = '═';
        }
        gui[rightX - 1][topY] = '═';
        gui[rightX][topY] = '╗';

        //bottom
        gui[leftX][bottomY] = '╚';
        for (int i = leftX + 1; i < rightX; i++) {
            gui[i][bottomY] = '═';
        }
        gui[rightX][bottomY] = '╝';

        //left
        for (int i = topY + 1; i < bottomY; i++) {
            gui[leftX][i] = '║';
        }

        //right
        for (int i = topY + 1; i < bottomY; i++) {
            gui[rightX][i] = '║';
        }
    }

    @Override
    protected void setWidth(int width) {
        this.width = width;
        nested.setWidth(width - 4);
    }

    @Override
    protected void setHeight(int height) {
        this.height = height;
        nested.setHeight(height - 2);
    }
}
