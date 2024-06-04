package problems;

import static java.util.Objects.isNull;

public class AddTwoNumbers {

    private static final int ZERO_INT = 0;
    private static final int ALLOCATION_NUMBER = 1;
    private static final int UPPER_BOUNDARY = 10;

    /*
    * https://leetcode.com/problems/add-two-numbers/
    *
    * You are given two non-empty linked lists representing two non-negative integers.
    * The digits are stored in reverse order, and each of their nodes contains a single digit.
    * Add the two numbers and return the sum as a linked list.
    *
    * */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var digitSum = l1.getVal() + l2.getVal();
        return sumDivisionsRecursively(
                digitSum >= UPPER_BOUNDARY ? new ListNode(digitSum - UPPER_BOUNDARY) : new ListNode(digitSum),
                isNull(l1.getNext()) ? null : l1.getNext(),
                isNull(l2.getNext()) ? null : l2.getNext(),
                digitSum >= UPPER_BOUNDARY);
    }

    private ListNode sumDivisionsRecursively(ListNode resultNumberNode, ListNode firstDigit,
                                             ListNode secondDigit, boolean isOverBounds) {

        if (isNull(firstDigit) && isNull(secondDigit)) {
            if (isOverBounds) {
                var overBoundaryNumber = new ListNode(ALLOCATION_NUMBER);
                resultNumberNode.setNext(overBoundaryNumber);
                return overBoundaryNumber;
            }
            return resultNumberNode;
        }

        var calculatedDigitSum =
                (isNull(firstDigit) ? ZERO_INT : firstDigit.getVal()) +
                        (isNull(secondDigit) ? ZERO_INT : secondDigit.getVal()) +
                        (isOverBounds ? ALLOCATION_NUMBER : ZERO_INT);

        var resultDigitNode = calculatedDigitSum >= UPPER_BOUNDARY ?
                new ListNode(calculatedDigitSum - UPPER_BOUNDARY) : new ListNode(calculatedDigitSum);

        resultNumberNode.setNext(resultDigitNode);
        sumDivisionsRecursively(
                resultDigitNode,
                isNull(firstDigit.getNext()) ? null : firstDigit.getNext(),
                isNull(secondDigit.getNext()) ? null : secondDigit.getNext(),
                calculatedDigitSum >= UPPER_BOUNDARY);

        return resultNumberNode;
    }
}
