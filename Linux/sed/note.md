![img.png](img.png)

```shell
#!/bin/bash

# 检查文件是否存在
if [ ! -f nowcoder.txt ]; then
    echo "文件 nowcoder.txt 不存在"
    exit 1
fi

# 使用sed命令进行替换
sed -i's/1[3-9][0-9]{9}/\0前6位\&\*\*\*\*/g' nowcoder.txt

echo "手机号码后4位替换完成"
```
![img_1.png](img_1.png)
![img_2.png](img_2.png)

```shell
#!/bin/bash

# 检查文件是否存在
if [ ! -f nowcoder.txt ]; then
    echo "文件 nowcoder.txt 不存在"
    exit 1
fi

# 使用sed命令进行格式转换
sed -i's/1[3-9][0-9]{9}/\1-\2-\3/g' nowcoder.txt <<< $(echo "$(cat nowcoder.txt)" | sed -E's/(1[3-9][0-9]{2})([0-9]{4})([0-9]{4})/\1 \2 \3/g')

echo "手机号码格式转换完成"
```