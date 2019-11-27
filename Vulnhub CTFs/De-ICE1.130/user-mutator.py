#!/usr/bin/python

import sys

from itertools import permutations
for group in permutations(['customer', 'c', 'service', 's', 'admin', 'a', 'administrator', '.'],3):
    print(''.join(group))
