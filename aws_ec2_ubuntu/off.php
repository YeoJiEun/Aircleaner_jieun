<?php

$command = escapeshellcmd('python3 air_off.py');
$output = shell_exec($command);
echo $output;

?>
