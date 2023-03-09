#include <iostream>
#include <string>
using namespace std;

int handleSubset(string subset) {
    int sepIdx = subset.find('-');
    if (sepIdx == string::npos) {
        return 1;
    }

    int left = stoi(subset.substr(0, sepIdx));
    int right = stoi(subset.substr(sepIdx + 1, string::npos));
    
    return right - left + 1;
}

int main() {
    int sepIdx;
    string input, subset;

    cin >> input;
    int stringLen = input.length();
    
    int count = 0;
    while (true) {
        sepIdx = input.find(';');
        if (sepIdx == string::npos) {
            count += handleSubset(input);
            break;
        }

        subset = input.substr(0, sepIdx);
        input = input.substr(sepIdx + 1, stringLen);

        count += handleSubset(subset);
    }
    cout << count;
}