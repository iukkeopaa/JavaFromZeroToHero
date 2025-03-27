![img.png](img.png)
![img_1.png](img_1.png)

```shell
tr ' ' '\n' < nowcoder.txt | grep -E '^.{6,}$'
```

```shell
awk '{for(i=1; i<=NF; i++) if(length($i)>5) print $i}' nowcoder.txt
```
![img_2.png](img_2.png)
![img_3.png](img_3.png)


```shell
grep -n "JD" nowcoder.txt | cut -d: -f1
```

```shell
awk '/JD/{print NR}' nowcoder.txt
```