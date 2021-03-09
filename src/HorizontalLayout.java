public class HorizontalLayout extends CalculableElement implements Container {
    private final CalculableElement[] nested;

    public HorizontalLayout(CalculableElement... nested) {
        this.nested = nested;
        width = getWidth();
        height = getHeight();
    }

    @Override
    public int getWidth() {
        int sumWidth = 0;
        for (CalculableElement el : nested) {
            sumWidth += el.width;
        }
        return sumWidth + 1;
    }

    @Override
    public int getHeight() {
        int maxHeight = Integer.MIN_VALUE;
        for (CalculableElement el : nested) {
            int curHeight = el.height;
            if (curHeight > maxHeight) {
                maxHeight = curHeight;
            }
        }
        return maxHeight;
    }

    @Override
    public void calculate() {
        int maxHeight = height;
        int curX = x;
        for (CalculableElement el : nested) {
            el.x = curX;
            el.y = y;
            curX += el.width + 1;
        }
        for (CalculableElement el : nested) {
            el.setHeight(maxHeight);
            el.calculate();
        }
        isCalculated = true;
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
    }

    @Override
    protected void setHeight(int height) {
        this.height = height;
        for (CalculableElement el : nested) {
            el.setHeight(height);
        }
    }
}
