![img.png](img.png)


```shell

#!/bin/bash

# �������ݴ洢��data.txt�ļ��У�����Ը���ʵ������޸��ļ���
input_file="data.txt"

# ʹ��awk�������ݴ���
awk '
BEGIN {
    printf "id "
    printf "score "
}
{
    printf $1 " "
    printf $2 " "
}
END {
    print ""
}' $input_file

```