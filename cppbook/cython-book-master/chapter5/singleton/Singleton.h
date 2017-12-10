#ifndef __HEADER_H__
#define __HEADER_H__


class MySingleton {
public:
    static MySingleton& getInstance() {
        static MySingleton s;
        return s;
    }

    int getValue() const { return m_value; }

    void setValue(int val) { m_value = val; }

    int doSomething(int val) {
        // some method
        return m_value + val;
    }

private:      
    MySingleton(): m_value(1234) { }

    int m_value;
};

#endif //__HEADER_H__
