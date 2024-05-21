# ls | ? { $_.Name -eq "bin" } #Retorna a pasta bin

if((ls | ? { $_.Name -eq "bin" }).Count -eq 0){
  mkdir bin
}
javac App.java -d bin

ls | ? { $_.Name.EndsWith(".fxml") } | % { cp $_ .\bin\ }

clear
cd bin
java App
cd ..