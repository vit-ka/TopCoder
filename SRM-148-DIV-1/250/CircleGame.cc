
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
#include <iterator>
#include <limits>
#include <list>
#include <map>
#include <unordered_map>
#include <numeric>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <utility>
#include <vector>

using namespace std;

// }}}

#define DEBUG(x) 

class CircleGame
{
private:
  unordered_map<char, int> cards = {
    {'A', 1},
    {'2', 2},
    {'3', 3},
    {'4', 4},
    {'5', 5},
    {'6', 6},
    {'7', 7},
    {'8', 8},
    {'9', 9},
    {'T', 10},
    {'J', 11},
    {'Q', 12},
    {'K', 13}
  };

public:
	int cardsLeft(string deck)
	{
    auto new_end = remove_if(deck.begin(), deck.end(), [=](char ch){return ch == 'K';});
    deck.erase(new_end, deck.end());

    auto prevDeckSize = std::numeric_limits<size_t>::max();
    vector<size_t> indexesToRemove;

    while (prevDeckSize > deck.size()) {
      prevDeckSize = deck.size();

      DEBUG(
          cout << "Next iteration: '" << deck << "'" << endl;
          )

      for (auto i = 0; i < deck.size(); ++i) {
        auto nextIndex = (i + 1) % deck.size();
        if (cards[deck[i]] + cards[deck[nextIndex]] == 13) {
          DEBUG(
            cout << "Remove(" << i << "," << nextIndex << ")" << endl;
          )

          if (find(indexesToRemove.begin(), indexesToRemove.end(), i) == indexesToRemove.end()
              && find(indexesToRemove.begin(), indexesToRemove.end(), nextIndex) == indexesToRemove.end()) {
            indexesToRemove.push_back(i);
            indexesToRemove.push_back(nextIndex);
          }
        }
      }

      sort(indexesToRemove.begin(), indexesToRemove.end());

      DEBUG(
        cout << "Removing indexes: ";
        copy(indexesToRemove.begin(), indexesToRemove.end(), ostream_iterator<int>(cout, ", "));
        cout << endl;
      )

      int indexer = 0;
      for (int i : indexesToRemove) {
        deck.erase(i - indexer++, 1);
      }
      indexesToRemove.clear();
    }
		return deck.size();
	}
};

