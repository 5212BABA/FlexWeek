#echo "hello world"
#read -p "Enter your name: " name
#echo "hello $name"
#if [ $name = "Jesse" ]
#then
#   echo "YO!!!"
#fi

for i in $(ls cities);
do
    echo $i
    java FileConverter "cities/$i" "output/compressed-$i"
done
