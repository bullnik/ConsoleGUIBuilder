public class VerticalLayout extends CalculableElement implements Container {
    private final CalculableElement[] nested;

    public VerticalLayout(CalculableElement... nested) {
        this.nested = nested;
        width = getWidth();
        height = getHeight();
    }

    @Override
    public void calculate() {
        int maxWidth = width;
        int curY = y;
        for (CalculableElement el : nested) {
            el.x = x;
            el.y = curY;
            curY += el.height;
        }
        for (CalculableElement el : nested) {
            el.setWidth(maxWidth);
            el.calculate();
        }
        isCalculated = true;
    }

    @Override
    public int getWidth() {
        int maxWidth = Integer.MIN_VALUE;
        for (CalculableElement el : nested) {
            int curWidth = el.width;
            if (curWidth > maxWidth) {
                maxWidth = curWidth;
            }
        }
        return maxWidth;
    }

    @Override
    public int getHeight() {
        int sumHeight = 0;
        for (CalculableElement el : nested) {
            int curHeight = el.height;
            sumHeight += curHeight;
        }
        return sumHeight;
    }

    @Override
    public void draw(char[][] gui) throws Exception {
        if (!isCalculated) {
            throw new Exception("Frame not calculated!");
        }

        for (CalculableElement el : nested) {
            el.draw(gui);
        }
    }

    @Override
    protected void setWidth(int width) {
        this.width = width;
        for (CalculableElement el : nested) {
            el.setWidth(width);
        }
    }

    @Override
    protected void setHeight(int height) {
        this.height = height;
    }
}
