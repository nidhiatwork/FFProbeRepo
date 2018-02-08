package myTest;

import java.io.IOException;

import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegFormat;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;

public class testMedia_mac {

public static void main(String[] args) throws IOException
{
	FFprobe ffprobe = new FFprobe("/usr/local/bin/ffprobe");
	FFmpegProbeResult probeResult = ffprobe.probe("/usr/local/testData/Cycle video.mp4");

	FFmpegFormat format = probeResult.getFormat();
	System.out.format("%nFile: '%s' ; Format: '%s' ; Duration: %.3fs", 
		format.filename, 
		format.format_long_name,
		format.duration
	);

	FFmpegStream stream = probeResult.getStreams().get(0);
	System.out.format("%nCodec: '%s' ; Width: %dpx ; Height: %dpx",
		stream.codec_long_name,
		stream.width,
		stream.height
	);
}

}
