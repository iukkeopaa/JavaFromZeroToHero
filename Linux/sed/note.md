![img.png](img.png)

```shell
#!/bin/bash

# ����ļ��Ƿ����
if [ ! -f nowcoder.txt ]; then
    echo "�ļ� nowcoder.txt ������"
    exit 1
fi

# ʹ��sed��������滻
sed -i's/1[3-9][0-9]{9}/\0ǰ6λ\&\*\*\*\*/g' nowcoder.txt

echo "�ֻ������4λ�滻���"
```
![img_1.png](img_1.png)
![img_2.png](img_2.png)

```shell
#!/bin/bash

# ����ļ��Ƿ����
if [ ! -f nowcoder.txt ]; then
    echo "�ļ� nowcoder.txt ������"
    exit 1
fi

# ʹ��sed������и�ʽת��
sed -i's/1[3-9][0-9]{9}/\1-\2-\3/g' nowcoder.txt <<< $(echo "$(cat nowcoder.txt)" | sed -E's/(1[3-9][0-9]{2})([0-9]{4})([0-9]{4})/\1 \2 \3/g')

echo "�ֻ������ʽת�����"
```