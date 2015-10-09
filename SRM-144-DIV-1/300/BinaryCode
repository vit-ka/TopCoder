
// {{{ VimCoder 0.3.6 <-----------------------------------------------------
// vim:filetype=cpp:foldmethod=marker:foldmarker={{{,}}}

#include <algorithm>
#include <bitset>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <ctime>
#include <deque>
#include <functional>
#include <iomanip>
#include <iostream>
#include <list>
#include <map>
#include <numeric>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <utility>
#include <vector>

using namespace std;

// }}}

class BinaryCode
{
public:
	vector <string> decode(string message)
	{
    return {decode_assuming('0', message), decode_assuming('1', message)};
  }

private:
  string decode_assuming(char firstDigit, string message) {
    string result(1, firstDigit);

    int prevPrevDecodedSymbol = 0;
    int preDecodedSymbol = firstDigit - '0';

    int i = 0;
    for (auto ch : message) {
      int currentEncodedSymbol = ch - '0';
      int currentDecodedSymbol = decode_current_symbol(preDecodedSymbol, prevPrevDecodedSymbol, currentEncodedSymbol);

      if (currentDecodedSymbol < 0 || currentDecodedSymbol > 1) {
        return "NONE";
      }

      if (i + 1 < message.size())
        result += (currentDecodedSymbol + '0');
      else if (currentDecodedSymbol != 0)
        return "NONE";

      prevPrevDecodedSymbol = preDecodedSymbol;
      preDecodedSymbol = currentDecodedSymbol;
      i++;
    }

    return result;
  }

  int decode_current_symbol(int prevDecodedSymbol, int prevPrevDecodedSymbol, int curEncodedSymbol) {
    return curEncodedSymbol - prevDecodedSymbol - prevPrevDecodedSymbol;
  }
};

