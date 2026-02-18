# Interview Questions - Day 12: CSS

## 1. What is the Box Model?
The Box Model explains how every HTML element is treated as a rectangular box. It consists of:
- **Content**: The actual text/image.
- **Padding**: Space between content and border.
- **Border**: Edge around the padding.
- **Margin**: Space outside the border (spacing between elements).

## 2. What is the difference between `class` and `id`?
- **ID (`#`)**: Unique. Can only be used **once** per page. High specificty.
- **Class (`.`)**: Reusable. Can be used on **multiple** elements. Lower specificity.

## 3. What is `display: none` vs `visibility: hidden`?
- `display: none`: The element is **removed** from the layout. It takes up **no space**.
- `visibility: hidden`: The element is **invisible** but still takes up its original **space**.

## 4. How do you center an element horizontally?
- For text/inline elements: `text-align: center` on the parent.
- For block elements: `margin: 0 auto;` (requires a width).
- Using Flexbox: `display: flex; justify-content: center;` on the parent.

## 5. What is Flexbox?
A CSS3 layout module designed to lay out items in a single dimension (row or column). It makes it easy to align items and distribute space within a container.

## 6. What does `* { box-sizing: border-box; }` do?
It tells the browser to include the **padding** and **border** in the element's total width and height. Without this, adding padding increases the size of the box, which often breaks layouts.
