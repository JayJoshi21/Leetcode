class Solution(object):
    def parseBoolExpr(self, expression):
        """
        :type expression: str
        :rtype: bool
        """
        # Stack to store elements of the expression
        stack = []

        for char in expression:
            if char == ',':
                # Skip commas as they only separate sub-expressions
                continue
            elif char in 'tf!&|':
                # Push boolean values and operators onto the stack
                stack.append(char)
            elif char == ')':
                # We have reached the end of a sub-expression
                sub_expr = []
                while stack and stack[-1] != '(':
                    sub_expr.append(stack.pop())
                # Remove the opening parenthesis
                stack.pop()
                # Get the operator before the '('
                operator = stack.pop()
                
                # Evaluate the sub-expression based on the operator
                if operator == '!':
                    result = 't' if sub_expr[0] == 'f' else 'f'
                elif operator == '&':
                    result = 't' if all(x == 't' for x in sub_expr) else 'f'
                elif operator == '|':
                    result = 't' if any(x == 't' for x in sub_expr) else 'f'
                
                # Push the result of the sub-expression onto the stack
                stack.append(result)
            else:
                # Push opening parenthesis '(' onto the stack
                stack.append(char)

        # The final result will be the last element in the stack
        return stack.pop() == 't'


