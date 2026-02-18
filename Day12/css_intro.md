# Introduction to CSS3

**CSS** stands for **Cascading Style Sheets**. It describes how HTML elements are to be displayed on screen, paper, or in other media.

## 1. Syntax
A CSS rule consists of a selector and a declaration block.

```css
h1 {
  color: blue;
  font-size: 12px;
}
```
- **Selector**: `h1` (Target specific HTML elements).
- **Property**: `color` (What you want to change).
- **Value**: `blue` (The new setting).

## 2. Three Ways to Insert CSS

### A. Inline CSS
Apply style uniquely to a single element. **Avoid this** unless necessary.
```html
<h1 style="color:blue;text-align:center;">Hello World</h1>
```

### B. Internal CSS
Define styles inside the `<head>` section of `index.html`. Good for single-page sites.
```html
<head>
<style>
body {
  background-color: linen;
}
h1 {
  color: maroon;
}
</style>
</head>
```

### C. External CSS (Best Practice)
Link to a separate `.css` file.
```html
<head>
  <link rel="stylesheet" href="style.css">
</head>
```

## 3. Colors & Fonts
- **Colors**: Can be names (`red`), Hex codes (`#FF0000`), or RGB (`rgb(255, 0, 0)`).
- **Fonts**: `font-family: Arial, sans-serif;`
- **Text Align**: `text-align: center;` (or left, right, justify).
