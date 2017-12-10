package com.java7book.chapter12.genericcomponent;


abstract class Component {
}

abstract class ComponentRenderer <C extends Component> {
    abstract void render(C component);
}

class Button extends Component {
}

class ButtonRenderer extends ComponentRenderer<Button> {
    void render(Button button) {
        //界面渲染
    }
}

public class GenericComponent {
    public void render() {
        ButtonRenderer renderer = new ButtonRenderer();
        renderer.render(new Button());
    }
}
