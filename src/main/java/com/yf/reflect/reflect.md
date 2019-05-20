# 反射的使用

### 1.获取Class对象的三种方式
* 1 Object ——> getClass(); 
* 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性 
* 3 通过Class类的静态方法：forName（String  className）(常用) 
 
### 2.通过反射获取构造方法并使用
1.获取构造方法

* 批量的方法
   > 所有”公有的”构造方法
   1. public Constructor[] getConstructors()
   > 获取所有的构造方法(包括私有、受保护、默认、公有) 
   2. public Constructor[] getDeclaredConstructors()

* 获取单个的方法
   > 获取单个的”公有的”构造方法
   1. public Constructor getConstructor(Class… parameterTypes)
   > 获取”某个构造方法”可以是私有的，或受保护、默认、公有 
   2. public Constructor getDeclaredConstructor(Class… parameterTypes)

2.调用构造方法
* Constructor–>newInstance(Object… initargs) 

### 3.获取成员变量并调用
1.获取成员变量

* 批量的成员变量
   > 获取所有的”公有字段”
   1. Field[] getFields()

   > 获取所有字段，包括：私有、受保护、默认、公有
   2. Field[] getDeclaredFields()

* 获取单个的成员变量
   > 获取某个”公有的”字段
   1. public Field getField(String fieldName)

   > 获取某个字段(可以是私有的) 
   2. public Field getDeclaredField(String fieldName)

2.调用成员变量
> 参数说明：1.obj:要设置的字段所在的对象；2.value:要为字段设置的值
* Field –> public void set(Object obj,Object value)

### 4.获取成员方法并调用
1.获取成员方法

* 批量的成员方法
   > 获取所有”公有方法”；（包含了父类的方法也包含Object类）
   1. public Method[] getMethods()

   > 获取所有的成员方法，包括私有的(不包括继承的) 
   2. public Method[] getDeclaredMethods()

* 获取单个的成员方法
   > 参数：name : 方法名；Class … : 形参的Class类型对象(公有的)
   1. public Method getMethod(String name,Class<?>… parameterTypes)

   > 参数：name : 方法名；Class … : 形参的Class类型对象(所有的)
   2. public Method getDeclaredMethod(String name,Class<?>… parameterTypes) 

2.调用成员方法
> 参数说明： obj : 要调用方法的对象；args:调用方式时所传递的实参
* Method –> public Object invoke(Object obj,Object… args)



* getName()：获得类的完整名字。
* getFields()：获得类的public类型的属性。
* getDeclaredFields()：获得类的所有属性。包括private 声明的和继承类
* getMethods()：获得类的public类型的方法。
* getDeclaredMethods()：获得类的所有方法。包括private 声明的和继承类
* getMethod(String name, Class[] parameterTypes)：获得类的特定方法，name参数指定方法的名字，parameterTypes 参数指定方法的参数类型。
* getConstructors()：获得类的public类型的构造方法。
* getConstructor(Class[] parameterTypes)：获得类的特定构造方法，parameterTypes 参数指定构造方法的参数类型。
* newInstance()：通过类的不带参数的构造方法创建这个类的一个对象。


### 5.反射main方法

### 6.反射方法的其它使用之—通过反射运行配置文件内容

### 7.反射方法的其它使用之—通过反射越过泛型检查