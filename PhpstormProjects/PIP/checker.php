<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<?php
  $error_message = "Ошибка валидации!<br>\n";
  $was_error = false;

  $radius = (is_numeric($_GET['r']) ? intval($_GET['r']) : null);
  $x = (is_numeric($_GET['x']) ? intval($_GET['x']) : null);
  $y = (is_numeric($_GET['y']) ? floatval($_GET['y']) : null);

  $start = microtime(true);

  if (is_null($x) || $x < -3 || $x > 5) {
      $error_message .= "Неверно указан параметр ‘x’. Пожалуйста, укажите целое значение из интервала [-3, 5].<br>\n";
      $was_error = true;
  }
  if (is_null($y) || $y <= -5 || $y >= 5) {
      $error_message .= "Неверно указан параметр ‘y’. Пожалуйста, укажите вещественное значение из интервала (-5, 3).<br>\n";
      $was_error = true;
  }
  if (is_null($radius) || $radius < 1 || $radius > 3) {
      $error_message .= "Неверно указан параметр ‘r’. Пожалуйста, укажите целое значение от 1 до 3.<br>\n";
      $was_error = true;
  }

  if(!$was_error) {
    $in2 = (0 <= $y && $y <= $radius) && (-$radius/2 <= $x && $x <= 0);
    $in3 = ($x <= 0 && $y <= 0) && ($x + $y*2 >= -$radius);
    $in4 = ($x >= 0 && $y <= 0) && ($x*$x + $y*$y <= $radius*$radius);
    $result = $in2 || $in3 || $in4;

    $result ? $result = "Точка входит в область.<br>\n" : $result = "Точка находится вне области.<br>\n";
  }
  $total_time = microtime(true) - $start;
?>
<table border="1" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr class="header" align="center">
      <td>
        <?php include 'header.php'; ?>
      </td>
    </tr>
    <tr>
      <td class="result" align="center">
        <?php
          echo $was_error ? $error_message : $result;
          echo date('Y-m-d H:i:s') . "<br>\n";
          echo $total_time . "<br>\n";
        ?>
      </td>
    </tr>
    <tr class="footer" align="center">
      <td>
        <?php include 'footer.php'; ?>
      </td>
    </tr>
  </tbody>
</table>
</body>
</html>
