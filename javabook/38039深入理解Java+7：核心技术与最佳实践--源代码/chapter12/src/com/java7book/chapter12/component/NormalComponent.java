package com.java7book.chapter12.component;

abstract class Component {
}

abstract class ComponentRenderer {
    abstract void render(Component window);
}

class Button extends Component { 
}

class Label extends Component { 
}

class ButtonRenderer extends ComponentRenderer {
    void render(Component window) {
       if (window instanceof Button) {
           //界面渲染
       }
       else {
           throw new IllegalArgumentException();
       }
    }
}

public class NormalComponent {
    public void render() {
        ButtonRenderer renderer = new ButtonRenderer();
        renderer.render(new Button());
        renderer.render(new Label());
    }
}
