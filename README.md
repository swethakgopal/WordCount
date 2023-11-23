#  WordCount Instructions
This command-line application analyses text files, generating a word count report sorted by the frequency of each word. By providing a file path as an argument, the app scans the file contents, presenting a list of words alongside the number of times each word appears within the file. The output is organised in descending order, listing the most frequent words first.

## Installation
To download the jar file: Go to the <a href="https://github.com/swethakgopal/WordCount/releases/tag/1.0.0">releases section<a/> and download the latest version of the Word Count application.

To download the entire codebase: Download the zipped folder to your local drive or git clone the repository from GitHub using the following command: `git clone git@github.com:swethakgopal/WordCount.git`

## How to Run
There are 2 ways to execute the project depending on your choice and specifications. 

### Running from Jar file
**Prerequisites**: Java 17 or the latest version must be installed
1. Open terminal
2. Change the location of the WordCount directory. For example, if the WordCount folder is saved in Documents: `cd Documents/WordCount`
3. Run `java -jar WordCounter.jar <Path of text file>`

### Compile and Run
**Prerequisites**: Java 8 or the latest version must be installed
1. Open terminal
2. Change the location of the WordCount directory. For example, if WordCount folder is saved in Documents: `cd Documents/WordCount`
3. Run `javac`
4. Run `java ./src/WordCounter <Path of text file>`
   - Note: I have attached two test input files named, TestFile1.txt and TestFile2.txt at the base directory if needed.
