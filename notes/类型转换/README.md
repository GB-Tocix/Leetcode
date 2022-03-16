# 类型转换



**显示转换（强制类型转换）**

命名的强制类型转换，一个命名的强制类型转换具有如下形式：

`cast-name<type>(expression)`

其中 `type` 是 `expression` 要转换的值，如果是引用类型，则结果是左值，

其中 `cast-name` 是：

- static-cast
- dynamic_cast
- const_cast
- reinterpret_cast



**static_cast**

任何具有明确定义的类型转换，只要不包含底层 const，都可以使用 `static_cast`。当需要把一个较大的算是类型赋值给较小的类型时，这非常有用。

此时，强制类型转换会告诉程序和读者：我们知道并且不在乎潜在的精度损失。