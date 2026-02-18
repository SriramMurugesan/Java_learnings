# HTML5 Important Tags for Static Web Pages

HTML (HyperText Markup Language) is the skeleton of a web page. HTML5 is the latest version.

## 1. Structure Tags
These tags define the basic structure of the document.
- `<!DOCTYPE html>`: Tells the browser this is an HTML5 document.
- `<html>`: The root element.
- `<head>`: Contains metadata (title, CSS links) not visible on the page.
- `<body>`: Contains the visible content (text, images, buttons).

## 2. Text Formatting
- `<h1>` to `<h6>`: Headings (h1 is largest, h6 is smallest).
- `<p>`: Paragraph.
- `<br>`: Line break.
- `<hr>`: Horizontal rule (line).
- `<b>` or `<strong>`: Bold text.
- `<i>` or `<em>`: Italic text.

## 3. Lists
- `<ul>` + `<li>`: Unordered List (Bullet points).
- `<ol>` + `<li>`: Ordered List (Numbers 1, 2, 3...).

## 4. Links & Images
- `<a href="url">Click Me</a>`: Hyperlink (Anchor tag).
- `<img src="image.jpg" alt="Description">`: Image (Self-closing).

## 5. Tables
Used for displaying data in rows and columns.
```html
<table border="1">
  <tr> <!-- Table Row -->
    <th>Name</th> <!-- Table Header -->
    <th>Age</th>
  </tr>
  <tr>
    <td>Alice</td> <!-- Table Data -->
    <td>25</td>
  </tr>
</table>
```

## 6. Forms (Crucial for Backend!)
Used to collect user input.
- `<form>`: Container for input elements.
- `<input type="text">`: Text box.
- `<input type="password">`: Password field (dots).
- `<input type="email">`: Email field (validates format).
- `<input type="radio">`: Radio button (select one).
- `<input type="checkbox">`: Checkbox (select multiple).
- `<input type="submit">`: Button to send data to the server.
- `<select>` + `<option>`: Dropdown list.

## 7. Semantic Tags (HTML5 Specials)
Tags that describe their meaning to the browser and developer.
- `<header>`: Top section of a page.
- `<nav>`: Navigation links.
- `<main>`: Main content area.
- `<footer>`: Bottom section (copyright, contacts).
- `<section>`: A thematic grouping of content.
