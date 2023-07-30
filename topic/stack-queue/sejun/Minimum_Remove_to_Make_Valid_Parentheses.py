class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        brancket_stack = []
        word_list = list(s)
        for index, word in enumerate(s):
            if word == '(':
                brancket_stack.append(index)
            elif word == ')':
                if brancket_stack:
                    brancket_stack.pop()
                else:
                    word_list[index] = ''

        while brancket_stack:
            target_index = brancket_stack.pop()
            word_list[target_index] = ''

        result = ''.join(word_list)
        return result
