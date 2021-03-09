abstract class CalculableElement implements GUIElement {
    protected int x = 0;
    protected int y = 0;
    protected int width = 0;
    protected int height = 0;
    protected abstract void setWidth(int width);
    protected abstract void setHeight(int height);
    protected boolean isCalculated = false;
}
