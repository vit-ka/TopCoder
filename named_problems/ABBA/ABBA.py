class ABBA(object):
    def canObtain(self, initial, target):
        initial = list(initial)
        target = list(target)
        i = len(target) - 1
        while i >= len(initial):
            if target[i] == 'A':
                i -= 1
                target = target[:-1]
            else:
                target = list(reversed(target[:-1]))
                i -= 1

        if target == initial:
            return "Possible"
        else:
            return "Impossible"

if __name__ == "__main__":
    print(ABBA().canObtain("B", "ABBA"))
    print(ABBA().canObtain("AB", "ABB"))
    print(ABBA().canObtain("BBAB", "ABABABABB"))
    print(ABBA().canObtain("BBBBABABBBBBBA", "BBBBABABBABBBBBBABABBBBBBBBABAABBBAA"))
    print(ABBA().canObtain("A", "BB"))
